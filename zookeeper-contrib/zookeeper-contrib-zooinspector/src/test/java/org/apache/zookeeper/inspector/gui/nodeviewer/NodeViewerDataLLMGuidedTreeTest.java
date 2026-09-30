// ###Test START##
package org.apache.zookeeper.inspector.gui.nodeviewer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NodeViewerDataLLMGuidedTreeTest {

    private static final long UI_TIMEOUT_MILLIS = 5000;

    private IconResource previousIconResource;

    @Before
    public void setIconResource() {
        previousIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
    }

    @After
    public void restoreIconResource() {
        ZooInspector.iconResource = previousIconResource;
    }

    @Test
    public void constructorConfiguresDataScroller() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);

        JScrollPane scroller = onEdt(() -> (JScrollPane) viewer.getComponent(0));
        assertNotNull(scroller.getViewport().getView());
        assertTrue(scroller.getViewport().getView() instanceof JTextPane);
        assertEquals(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,
                scroller.getHorizontalScrollBarPolicy());
        assertTrue(viewer.getComponent(1) instanceof JToolBar);
        assertEquals("Node Data", viewer.getTitle());
    }

    @Test
    public void emptySelectionLeavesDisplayedTextUnchanged() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        viewer.setZooInspectorManager(manager);
        setText(viewer, "existing contents");

        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.<String>emptyList());
            return null;
        });

        assertEquals("existing contents", getText(viewer));
        verifyNoInteractions(manager);
    }

    @Test
    public void nullDataFromManagerClearsDisplayedText() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/node")).thenReturn(null);
        viewer.setZooInspectorManager(manager);
        setText(viewer, "old contents");

        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.singletonList("/node"));
            return null;
        });

        waitForText(viewer, "");
        verify(manager).getData("/node");
    }

    @Test
    public void managerFailureClearsDisplayedText() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/broken")).thenThrow(new RuntimeException("lookup failed"));
        viewer.setZooInspectorManager(manager);
        setText(viewer, "old contents");

        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.singletonList("/broken"));
            return null;
        });

        waitForText(viewer, "");
        verify(manager).getData("/broken");
    }

    @Test
    public void settingManagerUsesNewManagerForSubsequentSelection() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager oldManager = mock(ZooInspectorNodeManager.class);
        ZooInspectorNodeManager newManager = mock(ZooInspectorNodeManager.class);
        when(newManager.getData("/node")).thenReturn("new manager data");

        viewer.setZooInspectorManager(oldManager);
        viewer.setZooInspectorManager(newManager);
        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.singletonList("/node"));
            return null;
        });

        waitForText(viewer, "new manager data");
        verifyNoInteractions(oldManager);
        verify(newManager).getData("/node");
    }

    @Test
    public void nullSelectionListThrowsNullPointerException() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);

        try {
            onEdt(() -> {
                viewer.nodeSelectionChanged(null);
                return null;
            });
        } catch (NullPointerException expected) {
            return;
        }

        throw new AssertionError("Expected a null selection list to be rejected");
    }

    private static void setText(NodeViewerData viewer, String text) throws Exception {
        onEdt(() -> {
            textPane(viewer).setText(text);
            return null;
        });
    }

    private static String getText(NodeViewerData viewer) throws Exception {
        return onEdt(() -> textPane(viewer).getText());
    }

    private static JTextPane textPane(NodeViewerData viewer) {
        JScrollPane scroller = (JScrollPane) viewer.getComponent(0);
        return (JTextPane) scroller.getViewport().getView();
    }

    private static void waitForText(NodeViewerData viewer, String expected) throws Exception {
        long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(UI_TIMEOUT_MILLIS);
        AtomicReference<String> currentText = new AtomicReference<String>();

        while (System.nanoTime() < deadline) {
            currentText.set(getText(viewer));
            if (expected.equals(currentText.get())) {
                return;
            }
            Thread.sleep(10);
        }

        assertEquals("Timed out waiting for node data to load", expected, currentText.get());
    }

    private static <T> T onEdt(EdtCallable<T> callable) throws Exception {
        if (SwingUtilities.isEventDispatchThread()) {
            return callable.call();
        }

        AtomicReference<T> result = new AtomicReference<T>();
        AtomicReference<Throwable> failure = new AtomicReference<Throwable>();
        SwingUtilities.invokeAndWait(() -> {
            try {
                result.set(callable.call());
            } catch (Throwable throwable) {
                failure.set(throwable);
            }
        });

        if (failure.get() != null) {
            if (failure.get() instanceof Exception) {
                throw (Exception) failure.get();
            }
            if (failure.get() instanceof Error) {
                throw (Error) failure.get();
            }
            throw new InvocationTargetException(failure.get());
        }
        return result.get();
    }

    private interface EdtCallable<T> {
        T call() throws Exception;
    }
}
// ###Test END##