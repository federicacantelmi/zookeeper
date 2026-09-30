package org.apache.zookeeper.inspector.gui.nodeviewer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JToolBar;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NodeViewerDataLLMZeroShotTest {

    private static final long UI_TIMEOUT_MILLIS = 5000;

     private IconResource prevIconResource;

    @Before
    public void setIcon() {
        // si salva il valore dell'icon resource
        this.prevIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
    }

    @Test
    public void constructorBuildsViewerAndGetTitleReturnsNodeData() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);

        assertEquals("Node Data", viewer.getTitle());
        assertEquals(2, viewer.getComponentCount());
        assertTrue(viewer.getComponent(0) instanceof JScrollPane);
        assertTrue(viewer.getComponent(1) instanceof JToolBar);

        JToolBar toolbar = (JToolBar) viewer.getComponent(1);
        assertFalse(toolbar.isFloatable());
        assertEquals(1, toolbar.getComponentCount());
        assertTrue(toolbar.getComponent(0) instanceof JButton);
    }

    @Test
    public void emptySelectionDoesNotRequestNodeData() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        viewer.setZooInspectorManager(manager);

        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.<String>emptyList());
            return null;
        });

        verify(manager, never()).getData(org.mockito.ArgumentMatchers.anyString());
    }

    @Test
    public void selectionLoadsDataForFirstSelectedNode() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/first")).thenReturn("node contents");
        viewer.setZooInspectorManager(manager);

        onEdt(() -> {
            viewer.nodeSelectionChanged(java.util.Arrays.asList("/first", "/second"));
            return null;
        });

        waitForText(viewer, "node contents");
        verify(manager).getData("/first");
        verify(manager, never()).getData("/second");
    }

    @Test
    public void saveButtonDoesNothingWhenNoNodeIsSelected() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        viewer.setZooInspectorManager(manager);

        JButton saveButton = onEdt(() -> (JButton) ((JToolBar) viewer.getComponent(1))
                .getComponent(0));
        onEdt(() -> {
            saveButton.doClick();
            return null;
        });

        verify(manager, never()).setData(
                org.mockito.ArgumentMatchers.anyString(),
                org.mockito.ArgumentMatchers.anyString());
    }

    private static void waitForText(NodeViewerData viewer, String expected) throws Exception {
        long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(UI_TIMEOUT_MILLIS);
        AtomicReference<String> currentText = new AtomicReference<String>();

        while (System.nanoTime() < deadline) {
            onEdt(() -> {
                JScrollPane scroller = (JScrollPane) viewer.getComponent(0);
                assertNotNull(scroller.getViewport().getView());
                currentText.set(((javax.swing.JTextPane) scroller.getViewport().getView()).getText());
                return null;
            });

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

    @After
    public void restoreIcon() {
        ZooInspector.iconResource = this.prevIconResource;
    }
}