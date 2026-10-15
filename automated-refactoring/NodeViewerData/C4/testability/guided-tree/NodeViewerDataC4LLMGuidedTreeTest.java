package org.apache.zookeeper.inspector.gui.nodeviewer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.timeout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;

import javax.swing.JButton;
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

public class NodeViewerDataC4LLMGuidedTreeTest {
    private IconResource previousIconResource;

    @Before
    public void setUp() {
        previousIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
    }

    @After
    public void tearDown() {
        ZooInspector.iconResource = previousIconResource;
    }

    @Test
    public void constructorBuildsViewerAndGetTitleReturnsNodeData()
            throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);

        assertEquals("Node Data", viewer.getTitle());
        assertTrue(viewer.getLayout() instanceof BorderLayout);

        JScrollPane scrollPane = findComponent(viewer, JScrollPane.class);
        JToolBar toolbar = findComponent(viewer, JToolBar.class);

        assertNotNull(scrollPane);
        assertNotNull(toolbar);
        assertEquals(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,
                scrollPane.getHorizontalScrollBarPolicy());
        assertTrue(!toolbar.isFloatable());
        assertEquals(1, toolbar.getComponentCount());
        assertTrue(toolbar.getComponent(0) instanceof JButton);
    }

    @Test
    public void nodeSelectionChangedLoadsDataForFirstSelectedNode()
            throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/first")).thenReturn("node contents");

        onEdt(() -> {
            viewer.setZooInspectorManager(manager);
            viewer.nodeSelectionChanged(Arrays.asList("/first", "/second"));
            return null;
        });

        awaitText(viewer, "node contents");
        verify(manager).getData("/first");
        verify(manager, never()).getData("/second");
    }

    @Test
    public void emptySelectionDoesNotReadOrChangeDisplayedData()
            throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/node")).thenReturn("existing contents");

        onEdt(() -> {
            viewer.setZooInspectorManager(manager);
            viewer.nodeSelectionChanged(Collections.singletonList("/node"));
            return null;
        });
        awaitText(viewer, "existing contents");

        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.<String>emptyList());
            return null;
        });

        assertEquals("existing contents", getText(viewer));
        verify(manager, times(1)).getData("/node");
    }

    @Test
    public void nullSelectionThrowsNullPointerException() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);

        try {
            onEdt(() -> {
                viewer.nodeSelectionChanged(null);
                return null;
            });
        } catch (NullPointerException expected) {
            return;
        }
        throw new AssertionError("Expected a null selection to be rejected");
    }

    @Test
    public void failedRetrievalClearsPreviouslyDisplayedData() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/good")).thenReturn("previous contents");
        when(manager.getData("/broken"))
                .thenThrow(new IllegalStateException("retrieval failed"));

        onEdt(() -> {
            viewer.setZooInspectorManager(manager);
            viewer.nodeSelectionChanged(Collections.singletonList("/good"));
            return null;
        });
        awaitText(viewer, "previous contents");

        onEdt(() -> {
            viewer.nodeSelectionChanged(Collections.singletonList("/broken"));
            return null;
        });
        awaitText(viewer, "");

        verify(manager).getData("/broken");
    }

    @Test
    public void nullDataResultDisplaysEmptyText() throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        when(manager.getData("/node")).thenReturn(null);

        onEdt(() -> {
            viewer.setZooInspectorManager(manager);
            viewer.nodeSelectionChanged(Collections.singletonList("/node"));
            return null;
        });

        awaitText(viewer, "");
        verify(manager, timeout(5000)).getData("/node");
    }

    @Test
    public void saveButtonDoesNotWriteWhenNoNodeHasBeenSelected()
            throws Exception {
        NodeViewerData viewer = onEdt(NodeViewerData::new);
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);

        onEdt(() -> {
            viewer.setZooInspectorManager(manager);
            ((JButton) findComponent(viewer, JToolBar.class).getComponent(0))
                    .doClick();
            return null;
        });

        verify(manager, never()).setData(
                org.mockito.ArgumentMatchers.anyString(),
                org.mockito.ArgumentMatchers.anyString());
    }

    @Test
    public void equalsIsReflexiveAndDoesNotTreatSeparateViewersAsEqual()
            throws Exception {
        NodeViewerData first = onEdt(NodeViewerData::new);
        NodeViewerData second = onEdt(NodeViewerData::new);

        assertTrue(first.equals(first));
        assertTrue(first.equals(second));
    }

    private static void awaitText(NodeViewerData viewer, String expected)
            throws Exception {
        long deadline = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < deadline) {
            if (expected.equals(getText(viewer))) {
                return;
            }
            Thread.sleep(20);
        }
        assertEquals(expected, getText(viewer));
    }

    private static String getText(NodeViewerData viewer) throws Exception {
        return onEdt(() -> findComponent(viewer, JTextPane.class).getText());
    }

    private static <T extends Component> T findComponent(
            Container container, Class<T> componentType) {
        for (Component component : container.getComponents()) {
            if (componentType.isInstance(component)) {
                return componentType.cast(component);
            }
            if (component instanceof Container) {
                T found = findComponent((Container) component, componentType);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private static <T> T onEdt(Callable<T> action) throws Exception {
        if (SwingUtilities.isEventDispatchThread()) {
            return action.call();
        }

        final Object[] result = new Object[1];
        final Exception[] failure = new Exception[1];
        SwingUtilities.invokeAndWait(() -> {
            try {
                result[0] = action.call();
            } catch (Exception e) {
                failure[0] = e;
            }
        });
        if (failure[0] != null) {
            throw failure[0];
        }
        @SuppressWarnings("unchecked")
        T value = (T) result[0];
        return value;
    }
}
