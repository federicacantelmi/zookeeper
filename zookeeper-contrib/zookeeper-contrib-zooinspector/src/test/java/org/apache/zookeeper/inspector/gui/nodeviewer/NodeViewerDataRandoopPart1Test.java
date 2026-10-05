package org.apache.zookeeper.inspector.gui.nodeviewer;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodeViewerDataRandoopPart1Test {

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
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test501");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        java.awt.event.MouseMotionListener mouseMotionListener8 = null;
        nodeViewerData0.removeMouseMotionListener(mouseMotionListener8);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData10 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData10.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray12 = nodeViewerData10.getInputMethodListeners();
        nodeViewerData10.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData10.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration20 = nodeViewerData10.getGraphicsConfiguration();
        boolean boolean21 = nodeViewerData10.isFocusCycleRoot();
        int int22 = nodeViewerData10.getY();
        java.awt.ComponentOrientation componentOrientation23 = nodeViewerData10.getComponentOrientation();
        nodeViewerData0.setComponentOrientation(componentOrientation23);
        javax.swing.event.AncestorListener ancestorListener25 = null;
        nodeViewerData0.removeAncestorListener(ancestorListener25);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNotNull(nodeViewerData10);
        org.junit.Assert.assertNotNull(inputMethodListenerArray12);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray12, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertNotNull(componentOrientation23);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test502");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        boolean boolean11 = nodeViewerData0.isFocusCycleRoot();
        java.awt.event.FocusEvent.Cause cause12 = null;
        boolean boolean13 = nodeViewerData0.requestFocusInWindow(cause12);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData14 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData14.invalidate();
        javax.swing.ActionMap actionMap16 = nodeViewerData14.getActionMap();
        nodeViewerData0.setActionMap(actionMap16);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData18 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData18.invalidate();
        nodeViewerData18.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener25 = null;
        nodeViewerData18.removeFocusListener(focusListener25);
        java.awt.event.InputMethodListener[] inputMethodListenerArray27 = nodeViewerData18.getInputMethodListeners();
        nodeViewerData18.firePropertyChange("hi!", (double) (byte) 10, (double) 100);
        boolean boolean32 = nodeViewerData18.isFocusOwner();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData33 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData33.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray35 = nodeViewerData33.getInputMethodListeners();
        nodeViewerData33.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData33.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration43 = nodeViewerData33.getGraphicsConfiguration();
        boolean boolean44 = nodeViewerData33.isFocusCycleRoot();
        java.awt.Color color45 = nodeViewerData33.getForeground();
        java.awt.Event event46 = null;
        boolean boolean49 = nodeViewerData33.mouseMove(event46, 4, (int) '4');
        javax.swing.KeyStroke[] keyStrokeArray50 = nodeViewerData33.getRegisteredKeyStrokes();
        nodeViewerData33.resetKeyboardActions();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData52 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData52.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray54 = nodeViewerData52.getInputMethodListeners();
        nodeViewerData52.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData52.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration62 = nodeViewerData52.getGraphicsConfiguration();
        java.awt.Image image63 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData64 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData64.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray66 = nodeViewerData64.getInputMethodListeners();
        boolean boolean67 = nodeViewerData52.prepareImage(image63, (java.awt.image.ImageObserver) nodeViewerData64);
        boolean boolean68 = nodeViewerData64.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener69 = null;
        nodeViewerData64.removePropertyChangeListener(propertyChangeListener69);
        javax.swing.InputMap inputMap71 = nodeViewerData64.getInputMap();
        java.lang.String str72 = nodeViewerData64.getUIClassID();
        java.awt.event.FocusListener focusListener73 = null;
        nodeViewerData64.addFocusListener(focusListener73);
        java.awt.image.ColorModel colorModel75 = nodeViewerData64.getColorModel();
        java.awt.event.MouseWheelListener[] mouseWheelListenerArray76 = nodeViewerData64.getMouseWheelListeners();
        java.awt.Component component77 = nodeViewerData33.add((java.awt.Component) nodeViewerData64);
        nodeViewerData64.paintImmediately((int) (short) 100, (int) (byte) 100, (int) '4', 4);
        javax.swing.event.AncestorListener ancestorListener83 = null;
        nodeViewerData64.addAncestorListener(ancestorListener83);
        nodeViewerData64.enable(false);
        // The following exception was thrown during execution in test generation
        try {
            nodeViewerData0.add((java.awt.Component) nodeViewerData18, (java.lang.Object) nodeViewerData64, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: cannot add to layout: constraint must be a string (or null)");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(nodeViewerData14);
        org.junit.Assert.assertNotNull(actionMap16);
        org.junit.Assert.assertNotNull(nodeViewerData18);
        org.junit.Assert.assertNotNull(inputMethodListenerArray27);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray27, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(nodeViewerData33);
        org.junit.Assert.assertNotNull(inputMethodListenerArray35);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray35, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration43);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(color45);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertNotNull(keyStrokeArray50);
        org.junit.Assert.assertArrayEquals(keyStrokeArray50, new javax.swing.KeyStroke[] {});
        org.junit.Assert.assertNotNull(nodeViewerData52);
        org.junit.Assert.assertNotNull(inputMethodListenerArray54);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray54, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration62);
        org.junit.Assert.assertNotNull(nodeViewerData64);
        org.junit.Assert.assertNotNull(inputMethodListenerArray66);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray66, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + true + "'", boolean67 == true);
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNotNull(inputMap71);
        org.junit.Assert.assertEquals("'" + str72 + "' != '" + "PanelUI" + "'", str72, "PanelUI");
        org.junit.Assert.assertNotNull(colorModel75);
        org.junit.Assert.assertNotNull(mouseWheelListenerArray76);
        org.junit.Assert.assertArrayEquals(mouseWheelListenerArray76, new java.awt.event.MouseWheelListener[] {});
        org.junit.Assert.assertNotNull(component77);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test503");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.Image image2 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData5 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData5.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray7 = nodeViewerData5.getInputMethodListeners();
        nodeViewerData5.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData5.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration15 = nodeViewerData5.getGraphicsConfiguration();
        boolean boolean16 = nodeViewerData5.isFocusCycleRoot();
        java.awt.Color color17 = nodeViewerData5.getForeground();
        java.awt.Event event18 = null;
        boolean boolean21 = nodeViewerData5.mouseMove(event18, 4, (int) '4');
        boolean boolean22 = nodeViewerData0.prepareImage(image2, (int) (byte) 100, (int) '4', (java.awt.image.ImageObserver) nodeViewerData5);
        java.awt.Insets insets23 = nodeViewerData0.insets();
        java.awt.datatransfer.DataFlavor[] dataFlavorArray24 = nodeViewerData0.getTransferDataFlavors();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(nodeViewerData5);
        org.junit.Assert.assertNotNull(inputMethodListenerArray7);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray7, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(color17);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(insets23);
        org.junit.Assert.assertNotNull(dataFlavorArray24);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test504");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        nodeViewerData0.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener7 = null;
        nodeViewerData0.removeFocusListener(focusListener7);
        nodeViewerData0.list();
        java.awt.Event event10 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData11 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData11.invalidate();
        nodeViewerData11.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener18 = null;
        nodeViewerData11.removeFocusListener(focusListener18);
        java.awt.Point point20 = nodeViewerData11.getLocation();
        boolean boolean21 = nodeViewerData0.action(event10, (java.lang.Object) nodeViewerData11);
        int int22 = nodeViewerData11.getDebugGraphicsOptions();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(nodeViewerData11);
        org.junit.Assert.assertNotNull(point20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 100 + "'", int22 == 100);
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test505");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        java.awt.Image image11 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        boolean boolean15 = nodeViewerData0.prepareImage(image11, (java.awt.image.ImageObserver) nodeViewerData12);
        javax.swing.InputMap inputMap17 = nodeViewerData12.getInputMap((int) (byte) 0);
        java.awt.event.MouseMotionListener mouseMotionListener18 = null;
        nodeViewerData12.removeMouseMotionListener(mouseMotionListener18);
        javax.swing.border.Border border20 = nodeViewerData12.getBorder();
        java.awt.Graphics graphics21 = null;
        nodeViewerData12.update(graphics21);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData23 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData23.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray25 = nodeViewerData23.getInputMethodListeners();
        nodeViewerData23.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData23.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration33 = nodeViewerData23.getGraphicsConfiguration();
        java.awt.Image image34 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData35 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData35.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray37 = nodeViewerData35.getInputMethodListeners();
        boolean boolean38 = nodeViewerData23.prepareImage(image34, (java.awt.image.ImageObserver) nodeViewerData35);
        boolean boolean39 = nodeViewerData35.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener40 = null;
        nodeViewerData35.removePropertyChangeListener(propertyChangeListener40);
        nodeViewerData35.transferFocusUpCycle();
        java.awt.Event event43 = null;
        boolean boolean45 = nodeViewerData35.action(event43, (java.lang.Object) 8);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData46 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData46.invalidate();
        nodeViewerData46.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener53 = null;
        nodeViewerData46.removeFocusListener(focusListener53);
        java.awt.Point point55 = nodeViewerData46.getLocation();
        java.awt.Dimension dimension56 = null;
        java.awt.Dimension dimension57 = nodeViewerData46.getSize(dimension56);
        java.awt.Dimension dimension58 = nodeViewerData35.getSize(dimension57);
        nodeViewerData12.setSize(dimension57);
        java.awt.event.ComponentListener[] componentListenerArray60 = nodeViewerData12.getComponentListeners();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(inputMap17);
        org.junit.Assert.assertNull(border20);
        org.junit.Assert.assertNotNull(nodeViewerData23);
        org.junit.Assert.assertNotNull(inputMethodListenerArray25);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray25, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration33);
        org.junit.Assert.assertNotNull(nodeViewerData35);
        org.junit.Assert.assertNotNull(inputMethodListenerArray37);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray37, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(nodeViewerData46);
        org.junit.Assert.assertNotNull(point55);
        org.junit.Assert.assertNotNull(dimension57);
        org.junit.Assert.assertNotNull(dimension58);
        org.junit.Assert.assertNotNull(componentListenerArray60);
        org.junit.Assert.assertArrayEquals(componentListenerArray60, new java.awt.event.ComponentListener[] {});
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test506");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        java.awt.Image image11 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        boolean boolean15 = nodeViewerData0.prepareImage(image11, (java.awt.image.ImageObserver) nodeViewerData12);
        boolean boolean16 = nodeViewerData12.isManagingFocus();
        java.awt.Event event17 = null;
        boolean boolean19 = nodeViewerData12.lostFocus(event17, (java.lang.Object) (short) 100);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData20 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData20.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray22 = nodeViewerData20.getInputMethodListeners();
        nodeViewerData20.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData20.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration30 = nodeViewerData20.getGraphicsConfiguration();
        java.awt.Image image31 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData32 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData32.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray34 = nodeViewerData32.getInputMethodListeners();
        boolean boolean35 = nodeViewerData20.prepareImage(image31, (java.awt.image.ImageObserver) nodeViewerData32);
        boolean boolean36 = nodeViewerData32.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener37 = null;
        nodeViewerData32.removePropertyChangeListener(propertyChangeListener37);
        javax.swing.InputMap inputMap39 = nodeViewerData32.getInputMap();
        java.awt.ComponentOrientation componentOrientation40 = null;
        nodeViewerData32.setComponentOrientation(componentOrientation40);
        java.awt.Color color42 = nodeViewerData32.getBackground();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData43 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData43.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray45 = nodeViewerData43.getInputMethodListeners();
        nodeViewerData43.paintImmediately(16, 16, (int) (short) 10, 10);
        java.awt.event.MouseEvent mouseEvent51 = null;
        java.awt.Point point52 = nodeViewerData43.getToolTipLocation(mouseEvent51);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData53 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData53.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray55 = nodeViewerData53.getInputMethodListeners();
        nodeViewerData53.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData53.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration63 = nodeViewerData53.getGraphicsConfiguration();
        java.awt.Image image64 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData65 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData65.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray67 = nodeViewerData65.getInputMethodListeners();
        boolean boolean68 = nodeViewerData53.prepareImage(image64, (java.awt.image.ImageObserver) nodeViewerData65);
        boolean boolean69 = nodeViewerData65.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener70 = null;
        nodeViewerData65.removePropertyChangeListener(propertyChangeListener70);
        nodeViewerData65.transferFocusUpCycle();
        java.awt.Event event73 = null;
        boolean boolean75 = nodeViewerData65.action(event73, (java.lang.Object) 8);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData76 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData76.invalidate();
        nodeViewerData76.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener83 = null;
        nodeViewerData76.removeFocusListener(focusListener83);
        java.awt.Point point85 = nodeViewerData76.getLocation();
        java.awt.Dimension dimension86 = null;
        java.awt.Dimension dimension87 = nodeViewerData76.getSize(dimension86);
        java.awt.Dimension dimension88 = nodeViewerData65.getSize(dimension87);
        nodeViewerData43.setMaximumSize(dimension87);
        java.awt.Dimension dimension90 = nodeViewerData32.getSize(dimension87);
        nodeViewerData12.setPreferredSize(dimension90);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(nodeViewerData20);
        org.junit.Assert.assertNotNull(inputMethodListenerArray22);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray22, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration30);
        org.junit.Assert.assertNotNull(nodeViewerData32);
        org.junit.Assert.assertNotNull(inputMethodListenerArray34);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray34, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(inputMap39);
        org.junit.Assert.assertNotNull(color42);
        org.junit.Assert.assertNotNull(nodeViewerData43);
        org.junit.Assert.assertNotNull(inputMethodListenerArray45);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray45, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(point52);
        org.junit.Assert.assertNotNull(nodeViewerData53);
        org.junit.Assert.assertNotNull(inputMethodListenerArray55);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray55, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration63);
        org.junit.Assert.assertNotNull(nodeViewerData65);
        org.junit.Assert.assertNotNull(inputMethodListenerArray67);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray67, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + true + "'", boolean68 == true);
        org.junit.Assert.assertTrue("'" + boolean69 + "' != '" + false + "'", boolean69 == false);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertNotNull(nodeViewerData76);
        org.junit.Assert.assertNotNull(point85);
        org.junit.Assert.assertNotNull(dimension87);
        org.junit.Assert.assertNotNull(dimension88);
        org.junit.Assert.assertNotNull(dimension90);
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test507");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        java.awt.Image image11 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        boolean boolean15 = nodeViewerData0.prepareImage(image11, (java.awt.image.ImageObserver) nodeViewerData12);
        boolean boolean16 = nodeViewerData12.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener17 = null;
        nodeViewerData12.removePropertyChangeListener(propertyChangeListener17);
        javax.swing.InputMap inputMap19 = nodeViewerData12.getInputMap();
        java.awt.ComponentOrientation componentOrientation20 = null;
        nodeViewerData12.setComponentOrientation(componentOrientation20);
        // The following exception was thrown during execution in test generation
        try {
            java.awt.Point point22 = nodeViewerData12.getLocationOnScreen();
            org.junit.Assert.fail("Expected exception of type java.awt.IllegalComponentStateException; message: component must be showing on the screen to determine its location");
        } catch (java.awt.IllegalComponentStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(inputMap19);
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test508");
        java.util.Locale locale0 = javax.swing.JComponent.getDefaultLocale();
        javax.swing.JComponent.setDefaultLocale(locale0);
        javax.swing.JComponent.setDefaultLocale(locale0);
        org.junit.Assert.assertNotNull(locale0);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test509");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        java.awt.Point point3 = nodeViewerData0.getLocation();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData4 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData4.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray6 = nodeViewerData4.getInputMethodListeners();
        nodeViewerData4.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData4.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration14 = nodeViewerData4.getGraphicsConfiguration();
        boolean boolean15 = nodeViewerData4.isFocusCycleRoot();
        java.awt.Color color16 = nodeViewerData4.getForeground();
        nodeViewerData4.firePropertyChange("ToolTipText", (double) (byte) 10, (double) (short) 1);
        boolean boolean21 = nodeViewerData4.isPreferredSizeSet();
        java.awt.Dimension dimension22 = nodeViewerData4.getPreferredSize();
        int int23 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData4);
        java.beans.PropertyChangeListener propertyChangeListener24 = null;
        nodeViewerData4.addPropertyChangeListener(propertyChangeListener24);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNotNull(point3);
        org.junit.Assert.assertNotNull(nodeViewerData4);
        org.junit.Assert.assertNotNull(inputMethodListenerArray6);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray6, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(color16);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(dimension22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test510");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        nodeViewerData0.paintImmediately((-1), 32, 32, (int) (short) 100);
        nodeViewerData0.setAlignmentX((float) 32);
        java.beans.PropertyChangeListener propertyChangeListener10 = null;
        nodeViewerData0.removePropertyChangeListener("hi!", propertyChangeListener10);
        org.junit.Assert.assertNotNull(nodeViewerData0);
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test511");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        java.awt.Image image11 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        boolean boolean15 = nodeViewerData0.prepareImage(image11, (java.awt.image.ImageObserver) nodeViewerData12);
        boolean boolean16 = nodeViewerData12.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener17 = null;
        nodeViewerData12.removePropertyChangeListener(propertyChangeListener17);
        javax.swing.InputMap inputMap19 = nodeViewerData12.getInputMap();
        java.lang.String str20 = nodeViewerData12.getUIClassID();
        java.awt.event.FocusListener focusListener21 = null;
        nodeViewerData12.addFocusListener(focusListener21);
        org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager zooInspectorNodeManager23 = null;
        nodeViewerData12.setZooInspectorManager(zooInspectorNodeManager23);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData25 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData25.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray27 = nodeViewerData25.getInputMethodListeners();
        nodeViewerData25.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData25.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration35 = nodeViewerData25.getGraphicsConfiguration();
        boolean boolean36 = nodeViewerData25.isFocusCycleRoot();
        java.util.Locale locale37 = nodeViewerData25.getLocale();
        java.awt.im.InputMethodRequests inputMethodRequests38 = nodeViewerData25.getInputMethodRequests();
        nodeViewerData25.move((-1), (int) '#');
        java.awt.Component component42 = nodeViewerData12.add((java.awt.Component) nodeViewerData25);
        nodeViewerData12.move(16, (int) (byte) 10);
        nodeViewerData12.nextFocus();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(inputMap19);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "PanelUI" + "'", str20, "PanelUI");
        org.junit.Assert.assertNotNull(nodeViewerData25);
        org.junit.Assert.assertNotNull(inputMethodListenerArray27);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray27, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration35);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(locale37);
        org.junit.Assert.assertNull(inputMethodRequests38);
        org.junit.Assert.assertNotNull(component42);
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test512");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        boolean boolean11 = nodeViewerData0.isFocusCycleRoot();
        java.awt.Color color12 = nodeViewerData0.getForeground();
        nodeViewerData0.setOpaque(true);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData15 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData15.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray17 = nodeViewerData15.getInputMethodListeners();
        nodeViewerData15.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData15.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration25 = nodeViewerData15.getGraphicsConfiguration();
        boolean boolean26 = nodeViewerData15.isFocusCycleRoot();
        int int27 = nodeViewerData15.getY();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData28 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData28.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray30 = nodeViewerData28.getInputMethodListeners();
        nodeViewerData28.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData28.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration38 = nodeViewerData28.getGraphicsConfiguration();
        boolean boolean39 = nodeViewerData28.isFocusCycleRoot();
        java.awt.Color color40 = nodeViewerData28.getForeground();
        nodeViewerData15.setForeground(color40);
        boolean boolean42 = nodeViewerData15.isOptimizedDrawingEnabled();
        java.awt.Event event43 = null;
        boolean boolean45 = nodeViewerData15.gotFocus(event43, (java.lang.Object) (byte) 0);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData46 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData46.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray48 = nodeViewerData46.getInputMethodListeners();
        nodeViewerData46.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData46.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration56 = nodeViewerData46.getGraphicsConfiguration();
        java.awt.Image image57 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData58 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData58.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray60 = nodeViewerData58.getInputMethodListeners();
        boolean boolean61 = nodeViewerData46.prepareImage(image57, (java.awt.image.ImageObserver) nodeViewerData58);
        javax.swing.InputMap inputMap63 = nodeViewerData58.getInputMap((int) (byte) 0);
        java.awt.Component component64 = nodeViewerData15.add((java.awt.Component) nodeViewerData58);
        int int65 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData58);
        javax.swing.KeyStroke[] keyStrokeArray66 = nodeViewerData0.getRegisteredKeyStrokes();
        int int67 = nodeViewerData0.getY();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(color12);
        org.junit.Assert.assertNotNull(nodeViewerData15);
        org.junit.Assert.assertNotNull(inputMethodListenerArray17);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray17, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 0 + "'", int27 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData28);
        org.junit.Assert.assertNotNull(inputMethodListenerArray30);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray30, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration38);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNotNull(color40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(nodeViewerData46);
        org.junit.Assert.assertNotNull(inputMethodListenerArray48);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray48, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration56);
        org.junit.Assert.assertNotNull(nodeViewerData58);
        org.junit.Assert.assertNotNull(inputMethodListenerArray60);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray60, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + true + "'", boolean61 == true);
        org.junit.Assert.assertNotNull(inputMap63);
        org.junit.Assert.assertNotNull(component64);
        org.junit.Assert.assertTrue("'" + int65 + "' != '" + (-1) + "'", int65 == (-1));
        org.junit.Assert.assertNotNull(keyStrokeArray66);
        org.junit.Assert.assertArrayEquals(keyStrokeArray66, new javax.swing.KeyStroke[] {});
        org.junit.Assert.assertTrue("'" + int67 + "' != '" + 0 + "'", int67 == 0);
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test513");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        nodeViewerData0.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener7 = null;
        nodeViewerData0.removeFocusListener(focusListener7);
        java.awt.Cursor cursor9 = null;
        nodeViewerData0.setCursor(cursor9);
        int int11 = nodeViewerData0.getX();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        nodeViewerData12.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData12.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration22 = nodeViewerData12.getGraphicsConfiguration();
        boolean boolean23 = nodeViewerData12.isFocusCycleRoot();
        java.awt.Color color24 = nodeViewerData12.getForeground();
        javax.swing.InputVerifier inputVerifier25 = nodeViewerData12.getInputVerifier();
        java.awt.event.HierarchyBoundsListener hierarchyBoundsListener26 = null;
        nodeViewerData12.addHierarchyBoundsListener(hierarchyBoundsListener26);
        nodeViewerData12.disable();
        java.awt.Component[] componentArray29 = nodeViewerData12.getComponents();
        java.awt.Component component32 = nodeViewerData12.locate(1, (int) (byte) 0);
        int int33 = nodeViewerData12.getX();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData34 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData34.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray36 = nodeViewerData34.getInputMethodListeners();
        java.awt.Point point37 = nodeViewerData34.getLocation();
        boolean boolean38 = nodeViewerData12.contains(point37);
        boolean boolean39 = nodeViewerData0.contains(point37);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(color24);
        org.junit.Assert.assertNull(inputVerifier25);
        org.junit.Assert.assertNotNull(componentArray29);
        org.junit.Assert.assertNull(component32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData34);
        org.junit.Assert.assertNotNull(inputMethodListenerArray36);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray36, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNotNull(point37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test514");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        javax.swing.ActionMap actionMap2 = nodeViewerData0.getActionMap();
        nodeViewerData0.setVisible(true);
        java.awt.event.MouseWheelListener[] mouseWheelListenerArray5 = nodeViewerData0.getMouseWheelListeners();
        nodeViewerData0.repaint((int) (byte) 10, (int) (short) 1, 10, (int) ' ');
        java.awt.image.ImageProducer imageProducer11 = null;
        java.awt.Image image12 = nodeViewerData0.createImage(imageProducer11);
        java.awt.Font font13 = nodeViewerData0.getFont();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(actionMap2);
        org.junit.Assert.assertNotNull(mouseWheelListenerArray5);
        org.junit.Assert.assertArrayEquals(mouseWheelListenerArray5, new java.awt.event.MouseWheelListener[] {});
        org.junit.Assert.assertNotNull(image12);
        org.junit.Assert.assertNotNull(font13);
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test515");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        java.awt.Image image11 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        boolean boolean15 = nodeViewerData0.prepareImage(image11, (java.awt.image.ImageObserver) nodeViewerData12);
        boolean boolean16 = nodeViewerData12.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener17 = null;
        nodeViewerData12.removePropertyChangeListener(propertyChangeListener17);
        javax.swing.InputMap inputMap19 = nodeViewerData12.getInputMap();
        java.awt.ComponentOrientation componentOrientation20 = null;
        nodeViewerData12.setComponentOrientation(componentOrientation20);
        java.awt.event.MouseWheelListener mouseWheelListener22 = null;
        nodeViewerData12.removeMouseWheelListener(mouseWheelListener22);
        java.awt.Graphics graphics24 = null;
        nodeViewerData12.paint(graphics24);
        java.awt.Event event26 = null;
        boolean boolean28 = nodeViewerData12.keyDown(event26, 64);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(inputMap19);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test516");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray2 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData0.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration10 = nodeViewerData0.getGraphicsConfiguration();
        java.awt.Image image11 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData12.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray14 = nodeViewerData12.getInputMethodListeners();
        boolean boolean15 = nodeViewerData0.prepareImage(image11, (java.awt.image.ImageObserver) nodeViewerData12);
        boolean boolean16 = nodeViewerData0.isBackgroundSet();
        java.awt.event.FocusListener focusListener17 = null;
        nodeViewerData0.addFocusListener(focusListener17);
        nodeViewerData0.transferFocusBackward();
        javax.swing.InputVerifier inputVerifier20 = nodeViewerData0.getInputVerifier();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(inputMethodListenerArray2);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray2, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration10);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertNotNull(inputMethodListenerArray14);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray14, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNull(inputVerifier20);
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test517");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        nodeViewerData0.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener7 = null;
        nodeViewerData0.removeFocusListener(focusListener7);
        int int9 = nodeViewerData0.getDebugGraphicsOptions();
        java.awt.Event event10 = null;
        boolean boolean13 = nodeViewerData0.mouseEnter(event10, 10, (int) '4');
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData14 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData14.invalidate();
        nodeViewerData14.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener21 = null;
        nodeViewerData14.removeFocusListener(focusListener21);
        java.awt.event.InputMethodListener[] inputMethodListenerArray23 = nodeViewerData14.getInputMethodListeners();
        nodeViewerData14.validate();
        java.awt.Dimension dimension25 = nodeViewerData14.getMinimumSize();
        nodeViewerData0.setPreferredSize(dimension25);
        nodeViewerData0.resize((int) (byte) -1, 100);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData30 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData30.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray32 = nodeViewerData30.getInputMethodListeners();
        nodeViewerData30.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData30.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration40 = nodeViewerData30.getGraphicsConfiguration();
        boolean boolean41 = nodeViewerData30.isFocusCycleRoot();
        java.awt.Color color42 = nodeViewerData30.getForeground();
        nodeViewerData0.setBackground(color42);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 100 + "'", int9 == 100);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(nodeViewerData14);
        org.junit.Assert.assertNotNull(inputMethodListenerArray23);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray23, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNotNull(dimension25);
        org.junit.Assert.assertNotNull(nodeViewerData30);
        org.junit.Assert.assertNotNull(inputMethodListenerArray32);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray32, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration40);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertNotNull(color42);
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test518");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        nodeViewerData0.paintImmediately((-1), 32, 32, (int) (short) 100);
        java.awt.event.FocusListener focusListener7 = null;
        nodeViewerData0.removeFocusListener(focusListener7);
        int int9 = nodeViewerData0.getDebugGraphicsOptions();
        javax.swing.border.Border border10 = nodeViewerData0.getBorder();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 100 + "'", int9 == 100);
        org.junit.Assert.assertNull(border10);
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataRandoopPart1Test.test519");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.invalidate();
        javax.swing.ActionMap actionMap2 = nodeViewerData0.getActionMap();
        nodeViewerData0.setVisible(true);
        nodeViewerData0.setDebugGraphicsOptions((int) (byte) 10);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData7 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData7.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray9 = nodeViewerData7.getInputMethodListeners();
        nodeViewerData7.paintImmediately(16, 16, (int) (short) 10, 10);
        nodeViewerData7.setDebugGraphicsOptions((int) (short) 100);
        java.awt.GraphicsConfiguration graphicsConfiguration17 = nodeViewerData7.getGraphicsConfiguration();
        java.awt.Image image18 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData19 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData19.invalidate();
        java.awt.event.InputMethodListener[] inputMethodListenerArray21 = nodeViewerData19.getInputMethodListeners();
        boolean boolean22 = nodeViewerData7.prepareImage(image18, (java.awt.image.ImageObserver) nodeViewerData19);
        boolean boolean23 = nodeViewerData19.isManagingFocus();
        java.beans.PropertyChangeListener propertyChangeListener24 = null;
        nodeViewerData19.removePropertyChangeListener(propertyChangeListener24);
        nodeViewerData19.transferFocusUpCycle();
        boolean boolean27 = nodeViewerData19.getIgnoreRepaint();
        java.awt.Rectangle rectangle28 = nodeViewerData19.bounds();
        nodeViewerData0.repaint(rectangle28);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(actionMap2);
        org.junit.Assert.assertNotNull(nodeViewerData7);
        org.junit.Assert.assertNotNull(inputMethodListenerArray9);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray9, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNull(graphicsConfiguration17);
        org.junit.Assert.assertNotNull(nodeViewerData19);
        org.junit.Assert.assertNotNull(inputMethodListenerArray21);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray21, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(rectangle28);
    }
}

