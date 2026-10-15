package org.apache.zookeeper.inspector.gui.nodeviewer;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodeViewerDataC1RandoopTest1 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC1RandoopTest1.test501");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDown(event1, (int) (byte) 100, (-1));
        java.awt.MenuComponent menuComponent5 = null;
        nodeViewerData0.remove(menuComponent5);
        java.awt.ImageCapabilities imageCapabilities9 = null;
        java.awt.image.VolatileImage volatileImage10 = nodeViewerData0.createVolatileImage((int) (byte) 1, (int) ' ', imageCapabilities9);
        java.awt.Container container11 = nodeViewerData0.getFocusCycleRootAncestor();
        boolean boolean12 = nodeViewerData0.getVerifyInputWhenFocusTarget();
        java.awt.Graphics graphics13 = nodeViewerData0.getGraphics();
        java.awt.Event event14 = null;
        // The following exception was thrown during execution in test generation
        try {
            nodeViewerData0.deliverEvent(event14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"x\" because \"e\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(volatileImage10);
        org.junit.Assert.assertNull(container11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
// flaky "1) test501(org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataC1RandoopTest1)":         org.junit.Assert.assertNotNull(graphics13);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC1RandoopTest1.test502");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean3 = nodeViewerData0.keyDown(event1, (int) '#');
        java.awt.im.InputContext inputContext4 = nodeViewerData0.getInputContext();
        java.beans.VetoableChangeListener[] vetoableChangeListenerArray5 = nodeViewerData0.getVetoableChangeListeners();
        java.awt.event.KeyListener keyListener6 = null;
        nodeViewerData0.addKeyListener(keyListener6);
        nodeViewerData0.setEnabled(false);
        java.awt.Event event10 = null;
        boolean boolean13 = nodeViewerData0.mouseMove(event10, (int) (short) 0, (int) ' ');
        nodeViewerData0.setAlignmentX((float) (short) -1);
        javax.swing.event.AncestorListener ancestorListener16 = null;
        nodeViewerData0.removeAncestorListener(ancestorListener16);
        boolean boolean18 = nodeViewerData0.isFocusOwner();
        javax.swing.JPopupMenu jPopupMenu19 = nodeViewerData0.getComponentPopupMenu();
        java.beans.PropertyChangeListener[] propertyChangeListenerArray20 = nodeViewerData0.getPropertyChangeListeners();
        java.awt.event.MouseMotionListener mouseMotionListener21 = null;
        nodeViewerData0.removeMouseMotionListener(mouseMotionListener21);
        nodeViewerData0.list();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData24 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event25 = null;
        boolean boolean28 = nodeViewerData24.mouseDown(event25, (int) (byte) 100, (-1));
        java.awt.MenuComponent menuComponent29 = null;
        nodeViewerData24.remove(menuComponent29);
        java.awt.ImageCapabilities imageCapabilities33 = null;
        java.awt.image.VolatileImage volatileImage34 = nodeViewerData24.createVolatileImage((int) (byte) 1, (int) ' ', imageCapabilities33);
        org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager zooInspectorNodeManager35 = null;
        nodeViewerData24.setZooInspectorManager(zooInspectorNodeManager35);
        java.awt.event.MouseListener mouseListener37 = null;
        nodeViewerData24.addMouseListener(mouseListener37);
        boolean boolean39 = nodeViewerData24.isFocusCycleRoot();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData40 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event41 = null;
        boolean boolean44 = nodeViewerData40.mouseDown(event41, (int) (byte) 100, (-1));
        java.awt.datatransfer.DataFlavor dataFlavor45 = org.apache.zookeeper.inspector.gui.nodeviewer.ZooInspectorNodeViewer.nodeViewerDataFlavor;
        java.lang.Object obj46 = nodeViewerData40.getTransferData(dataFlavor45);
        java.awt.Container container47 = nodeViewerData40.getParent();
        java.awt.event.MouseListener[] mouseListenerArray48 = nodeViewerData40.getMouseListeners();
        java.awt.dnd.DropTarget dropTarget49 = null;
        nodeViewerData40.setDropTarget(dropTarget49);
        java.awt.Cursor cursor51 = nodeViewerData40.getCursor();
        nodeViewerData24.setCursor(cursor51);
        nodeViewerData24.setEnabled(true);
        javax.swing.JPopupMenu jPopupMenu55 = null;
        nodeViewerData24.setComponentPopupMenu(jPopupMenu55);
        java.lang.String[] strArray63 = new java.lang.String[] { "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", "Node Data", "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData[,0,0,0x0,invalid,layout=java.awt.BorderLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]", "hi!", "PanelUI" };
        java.util.ArrayList<java.lang.String> strList64 = new java.util.ArrayList<java.lang.String>();
        boolean boolean65 = java.util.Collections.addAll((java.util.Collection<java.lang.String>) strList64, strArray63);
        nodeViewerData24.nodeSelectionChanged((java.util.List<java.lang.String>) strList64);
        nodeViewerData0.nodeSelectionChanged((java.util.List<java.lang.String>) strList64);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(inputContext4);
        org.junit.Assert.assertNotNull(vetoableChangeListenerArray5);
        org.junit.Assert.assertArrayEquals(vetoableChangeListenerArray5, new java.beans.VetoableChangeListener[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNull(jPopupMenu19);
        org.junit.Assert.assertNotNull(propertyChangeListenerArray20);
        org.junit.Assert.assertArrayEquals(propertyChangeListenerArray20, new java.beans.PropertyChangeListener[] {});
        org.junit.Assert.assertNotNull(nodeViewerData24);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNull(volatileImage34);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNotNull(nodeViewerData40);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(dataFlavor45);
        org.junit.Assert.assertEquals("'" + obj46 + "' != '" + "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData" + "'", obj46, "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData");
        org.junit.Assert.assertNull(container47);
        org.junit.Assert.assertNotNull(mouseListenerArray48);
        org.junit.Assert.assertArrayEquals(mouseListenerArray48, new java.awt.event.MouseListener[] {});
        org.junit.Assert.assertNotNull(cursor51);
        org.junit.Assert.assertNotNull(strArray63);
        org.junit.Assert.assertArrayEquals(strArray63, new java.lang.String[] { "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", "Node Data", "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData[,0,0,0x0,invalid,layout=java.awt.BorderLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]", "hi!", "PanelUI" });
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + true + "'", boolean65 == true);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC1RandoopTest1.test503");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean3 = nodeViewerData0.keyDown(event1, (int) '#');
        java.awt.im.InputContext inputContext4 = nodeViewerData0.getInputContext();
        java.beans.VetoableChangeListener[] vetoableChangeListenerArray5 = nodeViewerData0.getVetoableChangeListeners();
        java.awt.event.KeyListener keyListener6 = null;
        nodeViewerData0.addKeyListener(keyListener6);
        nodeViewerData0.setEnabled(false);
        java.awt.Event event10 = null;
        boolean boolean13 = nodeViewerData0.mouseMove(event10, (int) (short) 0, (int) ' ');
        nodeViewerData0.setAlignmentX((float) (short) -1);
        javax.swing.event.AncestorListener ancestorListener16 = null;
        nodeViewerData0.removeAncestorListener(ancestorListener16);
        nodeViewerData0.setVerifyInputWhenFocusTarget(true);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData20 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event21 = null;
        boolean boolean24 = nodeViewerData20.mouseDown(event21, (int) (byte) 100, (-1));
        java.awt.MenuComponent menuComponent25 = null;
        nodeViewerData20.remove(menuComponent25);
        nodeViewerData20.revalidate();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData28 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Point point29 = null;
        java.awt.Point point30 = nodeViewerData28.getLocation(point29);
        java.awt.event.ContainerListener containerListener31 = null;
        nodeViewerData28.removeContainerListener(containerListener31);
        boolean boolean33 = nodeViewerData28.isMaximumSizeSet();
        nodeViewerData28.setLocation(64, 64);
        java.awt.event.HierarchyBoundsListener[] hierarchyBoundsListenerArray37 = nodeViewerData28.getHierarchyBoundsListeners();
        java.lang.Object obj38 = nodeViewerData20.getClientProperty((java.lang.Object) hierarchyBoundsListenerArray37);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData39 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event40 = null;
        boolean boolean42 = nodeViewerData39.keyDown(event40, (int) '#');
        java.awt.im.InputContext inputContext43 = nodeViewerData39.getInputContext();
        java.beans.VetoableChangeListener[] vetoableChangeListenerArray44 = nodeViewerData39.getVetoableChangeListeners();
        java.awt.event.KeyListener keyListener45 = null;
        nodeViewerData39.addKeyListener(keyListener45);
        nodeViewerData39.setEnabled(false);
        java.awt.event.FocusEvent.Cause cause49 = null;
        nodeViewerData39.requestFocus(cause49);
        java.beans.VetoableChangeListener[] vetoableChangeListenerArray51 = nodeViewerData39.getVetoableChangeListeners();
        javax.swing.border.Border border52 = null;
        nodeViewerData39.setBorder(border52);
        java.awt.image.ImageProducer imageProducer54 = null;
        java.awt.Image image55 = nodeViewerData39.createImage(imageProducer54);
        boolean boolean61 = nodeViewerData20.imageUpdate(image55, (int) ' ', 0, (int) (short) 100, (-1), 100);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData64 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event65 = null;
        boolean boolean68 = nodeViewerData64.mouseDown(event65, (int) (byte) 100, (-1));
        java.awt.MenuComponent menuComponent69 = null;
        nodeViewerData64.remove(menuComponent69);
        java.awt.ImageCapabilities imageCapabilities73 = null;
        java.awt.image.VolatileImage volatileImage74 = nodeViewerData64.createVolatileImage((int) (byte) 1, (int) ' ', imageCapabilities73);
        java.awt.Container container75 = nodeViewerData64.getFocusCycleRootAncestor();
        nodeViewerData64.repaint((long) (byte) 1);
        int int78 = nodeViewerData0.checkImage(image55, 4, 128, (java.awt.image.ImageObserver) nodeViewerData64);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(inputContext4);
        org.junit.Assert.assertNotNull(vetoableChangeListenerArray5);
        org.junit.Assert.assertArrayEquals(vetoableChangeListenerArray5, new java.beans.VetoableChangeListener[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(nodeViewerData20);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(nodeViewerData28);
        org.junit.Assert.assertNotNull(point30);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(hierarchyBoundsListenerArray37);
        org.junit.Assert.assertArrayEquals(hierarchyBoundsListenerArray37, new java.awt.event.HierarchyBoundsListener[] {});
        org.junit.Assert.assertNull(obj38);
        org.junit.Assert.assertNotNull(nodeViewerData39);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNull(inputContext43);
        org.junit.Assert.assertNotNull(vetoableChangeListenerArray44);
        org.junit.Assert.assertArrayEquals(vetoableChangeListenerArray44, new java.beans.VetoableChangeListener[] {});
        org.junit.Assert.assertNotNull(vetoableChangeListenerArray51);
        org.junit.Assert.assertArrayEquals(vetoableChangeListenerArray51, new java.beans.VetoableChangeListener[] {});
        org.junit.Assert.assertNotNull(image55);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(nodeViewerData64);
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNull(volatileImage74);
        org.junit.Assert.assertNull(container75);
        org.junit.Assert.assertTrue("'" + int78 + "' != '" + 0 + "'", int78 == 0);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC1RandoopTest1.test504");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDown(event1, (int) (byte) 100, (-1));
        java.awt.MenuComponent menuComponent5 = null;
        nodeViewerData0.remove(menuComponent5);
        nodeViewerData0.revalidate();
        boolean boolean8 = nodeViewerData0.isFocusOwner();
        javax.swing.InputVerifier inputVerifier9 = nodeViewerData0.getInputVerifier();
        java.awt.ImageCapabilities imageCapabilities12 = null;
        java.awt.image.VolatileImage volatileImage13 = nodeViewerData0.createVolatileImage(10, (int) ' ', imageCapabilities12);
        boolean boolean14 = nodeViewerData0.isDisplayable();
        boolean boolean15 = nodeViewerData0.isMinimumSizeSet();
        java.awt.Image image18 = nodeViewerData0.createImage((int) (short) -1, (int) (byte) 0);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(inputVerifier9);
        org.junit.Assert.assertNull(volatileImage13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNull(image18);
    }
}
