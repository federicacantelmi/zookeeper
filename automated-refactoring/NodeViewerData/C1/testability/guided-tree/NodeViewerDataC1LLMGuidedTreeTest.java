package org.apache.zookeeper.inspector.gui.nodeviewer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Component;
import java.awt.Container;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.junit.After;


import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;
import org.junit.Before;
import org.junit.Test;

public class NodeViewerDataC1LLMGuidedTreeTest {
    private IconResource previousIconResource;

    private static final String NODE = "/test-node";

    private NodeViewerData viewer;
    private ZooInspectorNodeManager manager;
    private JTextPane dataArea;

    @Before
    public void setUp() throws Exception {
        previousIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
        manager = mock(ZooInspectorNodeManager.class);

        onEdt(() -> {
            viewer = new NodeViewerData();
            viewer.setZooInspectorManager(manager);
            dataArea = findComponent(viewer, JTextPane.class);
        });
        assertNotNull("The viewer should contain a text pane", dataArea);
    }

    @After
    public void tearDown() {
        ZooInspector.iconResource = previousIconResource;
    }

    @Test
    public void getTitleReturnsNodeData() {
        assertEquals("Node Data", viewer.getTitle());
    }

    @Test
    public void constructorCreatesToolbarAndNonScrollableHorizontalPane()
            throws Exception {
        onEdt(() -> {
            JToolBar toolbar = findComponent(viewer, JToolBar.class);
            JScrollPane scrollPane = findComponent(viewer, JScrollPane.class);

            assertNotNull(toolbar);
            assertFalse(toolbar.isFloatable());
            assertEquals(1, toolbar.getComponentCount());
            assertTrue(toolbar.getComponent(0) instanceof JButton);

            assertNotNull(scrollPane);
            assertEquals(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,
                    scrollPane.getHorizontalScrollBarPolicy());
        });
    }

    @Test
    public void nodeSelectionLoadsDataForFirstSelectedNode() throws Exception {
        String expectedData = "node contents";
        CountDownLatch requestStarted = new CountDownLatch(1);
        when(manager.getData(NODE)).thenAnswer(invocation -> {
            requestStarted.countDown();
            return expectedData;
        });

        viewer.nodeSelectionChanged(Arrays.asList(NODE, "/ignored-node"));

        assertTrue("Expected the manager to retrieve node data",
                requestStarted.await(5, TimeUnit.SECONDS));
        awaitDisplayedData(expectedData);
        verify(manager).getData(NODE);
    }

    @Test
    public void emptySelectionLeavesDisplayedDataUntouched() throws Exception {
        setDisplayedData("existing contents");

        viewer.nodeSelectionChanged(Collections.emptyList());

        assertEquals("existing contents", getDisplayedData());
        verify(manager, never()).getData(NODE);
    }

    @Test
    public void retrievalFailureClearsPreviouslyDisplayedData() throws Exception {
        CountDownLatch requestStarted = new CountDownLatch(1);
        when(manager.getData(NODE)).thenAnswer(invocation -> {
            requestStarted.countDown();
            throw new IllegalStateException("retrieval failed");
        });
        setDisplayedData("stale contents");

        viewer.nodeSelectionChanged(Collections.singletonList(NODE));

        assertTrue("Expected the manager request to start",
                requestStarted.await(5, TimeUnit.SECONDS));
        awaitDisplayedData("");
        verify(manager).getData(NODE);
    }

    @Test
    public void nullSelectionListIsRejected() {
        try {
            viewer.nodeSelectionChanged(null);
            fail("Expected a null selection list to be rejected");
        } catch (NullPointerException expected) {
            // The method requires a non-null list.
        }
    }

    private void setDisplayedData(String text) throws Exception {
        onEdt(() -> dataArea.setText(text));
    }

    private String getDisplayedData() throws Exception {
        AtomicReference<String> text = new AtomicReference<>();
        onEdt(() -> text.set(dataArea.getText()));
        return text.get();
    }

    private void awaitDisplayedData(String expected) throws Exception {
        long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
        while (System.nanoTime() < deadline) {
            if (expected.equals(getDisplayedData())) {
                return;
            }
            Thread.sleep(20);
        }
        assertEquals("Timed out waiting for displayed data",
                expected, getDisplayedData());
    }

    private static void onEdt(Runnable action) throws Exception {
        if (SwingUtilities.isEventDispatchThread()) {
            action.run();
        } else {
            SwingUtilities.invokeAndWait(action);
        }
    }

    private static <T extends Component> T findComponent(
            Container parent, Class<T> componentType) {
        for (Component component : parent.getComponents()) {
            if (componentType.isInstance(component)) {
                return componentType.cast(component);
            }
            if (component instanceof Container) {
                T match = findComponent((Container) component, componentType);
                if (match != null) {
                    return match;
                }
            }
        }
        return null;
    }
}
