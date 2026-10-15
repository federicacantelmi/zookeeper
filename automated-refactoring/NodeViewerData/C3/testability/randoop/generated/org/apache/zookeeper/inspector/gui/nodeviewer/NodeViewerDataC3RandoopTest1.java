package org.apache.zookeeper.inspector.gui.nodeviewer;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodeViewerDataC3RandoopTest1 {

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
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test501");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData1 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int2 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData1);
        java.awt.event.ComponentListener[] componentListenerArray3 = nodeViewerData0.getComponentListeners();
        nodeViewerData0.transferFocus();
        int int5 = nodeViewerData0.getDebugGraphicsOptions();
        nodeViewerData0.revalidate();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(nodeViewerData1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(componentListenerArray3);
        org.junit.Assert.assertArrayEquals(componentListenerArray3, new java.awt.event.ComponentListener[] {});
// flaky "1) test501(org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataC3RandoopTest1)":         org.junit.Assert.assertTrue("'" + int5 + "' != '" + 2 + "'", int5 == 2);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test502");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        javax.accessibility.AccessibleContext accessibleContext1 = nodeViewerData0.getAccessibleContext();
        java.awt.LayoutManager layoutManager2 = null;
        nodeViewerData0.setLayout(layoutManager2);
        java.awt.Dimension dimension4 = nodeViewerData0.getMinimumSize();
        nodeViewerData0.setAlignmentX((float) 0);
        javax.swing.JRootPane jRootPane7 = nodeViewerData0.getRootPane();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(accessibleContext1);
        org.junit.Assert.assertNotNull(dimension4);
        org.junit.Assert.assertNull(jRootPane7);
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test503");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        int int6 = nodeViewerData0.getX();
        java.awt.Insets insets7 = nodeViewerData0.insets();
        nodeViewerData0.removeAll();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData9 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData10 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int11 = nodeViewerData9.getComponentZOrder((java.awt.Component) nodeViewerData10);
        int int12 = nodeViewerData10.countComponents();
        boolean boolean13 = nodeViewerData10.isFocusTraversalPolicyProvider();
        nodeViewerData10.enable(false);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData16 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Dimension dimension17 = nodeViewerData16.getSize();
        java.awt.datatransfer.DataFlavor dataFlavor18 = org.apache.zookeeper.inspector.gui.nodeviewer.ZooInspectorNodeViewer.nodeViewerDataFlavor;
        java.lang.Object obj19 = nodeViewerData16.getTransferData(dataFlavor18);
        nodeViewerData10.remove((java.awt.Component) nodeViewerData16);
        javax.swing.plaf.PanelUI panelUI21 = nodeViewerData10.getUI();
        nodeViewerData0.setUI(panelUI21);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(insets7);
        org.junit.Assert.assertNotNull(nodeViewerData9);
        org.junit.Assert.assertNotNull(nodeViewerData10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 2 + "'", int12 == 2);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(nodeViewerData16);
        org.junit.Assert.assertNotNull(dimension17);
        org.junit.Assert.assertNotNull(dataFlavor18);
        org.junit.Assert.assertEquals("'" + obj19 + "' != '" + "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData" + "'", obj19, "org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData");
        org.junit.Assert.assertNotNull(panelUI21);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test504");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        int int6 = nodeViewerData0.getX();
        nodeViewerData0.setName("ToolTipText");
        nodeViewerData0.setAlignmentY((float) 2);
        boolean boolean11 = nodeViewerData0.getVerifyInputWhenFocusTarget();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData12 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event13 = null;
        boolean boolean16 = nodeViewerData12.mouseDrag(event13, 32, (int) (byte) -1);
        boolean boolean17 = nodeViewerData12.isPaintingTile();
        int int18 = nodeViewerData12.getX();
        java.awt.Insets insets19 = nodeViewerData12.insets();
        nodeViewerData12.removeAll();
        java.awt.event.InputMethodListener[] inputMethodListenerArray21 = nodeViewerData12.getInputMethodListeners();
        boolean boolean22 = nodeViewerData0.isFocusCycleRoot((java.awt.Container) nodeViewerData12);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData24 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData24.enable(true);
        boolean boolean29 = nodeViewerData24.contains((int) (short) 1, (int) ' ');
        java.awt.event.FocusListener focusListener30 = null;
        nodeViewerData24.removeFocusListener(focusListener30);
        boolean boolean32 = nodeViewerData24.isCursorSet();
        javax.swing.InputMap inputMap33 = nodeViewerData24.getInputMap();
        nodeViewerData0.setInputMap((int) (byte) 1, inputMap33);
        java.awt.event.InputMethodListener[] inputMethodListenerArray35 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.firePropertyChange("org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", (byte) -1, (byte) -1);
        nodeViewerData0.setOpaque(false);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(nodeViewerData12);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertNotNull(insets19);
        org.junit.Assert.assertNotNull(inputMethodListenerArray21);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray21, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(nodeViewerData24);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(inputMap33);
        org.junit.Assert.assertNotNull(inputMethodListenerArray35);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray35, new java.awt.event.InputMethodListener[] {});
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test505");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        javax.swing.plaf.PanelUI panelUI6 = null;
        nodeViewerData0.setUI(panelUI6);
        java.awt.Event event8 = null;
        boolean boolean11 = nodeViewerData0.mouseDrag(event8, 16, (int) '#');
        java.awt.Image image14 = nodeViewerData0.createImage(8, 1);
        java.awt.GraphicsConfiguration graphicsConfiguration15 = nodeViewerData0.getGraphicsConfiguration();
        javax.swing.TransferHandler transferHandler16 = nodeViewerData0.getTransferHandler();
        boolean boolean17 = javax.swing.JComponent.isLightweightComponent((java.awt.Component) nodeViewerData0);
        java.awt.event.ComponentListener componentListener18 = null;
        nodeViewerData0.addComponentListener(componentListener18);
        java.awt.Color color20 = nodeViewerData0.getBackground();
        boolean boolean23 = nodeViewerData0.inside(16, (int) '4');
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(image14);
        org.junit.Assert.assertNull(graphicsConfiguration15);
        org.junit.Assert.assertNull(transferHandler16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(color20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test506");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData1 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int2 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData1);
        java.awt.event.KeyListener keyListener3 = null;
        nodeViewerData0.addKeyListener(keyListener3);
        nodeViewerData0.addNotify();
        nodeViewerData0.doLayout();
        boolean boolean7 = nodeViewerData0.isOptimizedDrawingEnabled();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData8 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData8.enable(true);
        boolean boolean13 = nodeViewerData8.contains((int) (short) 1, (int) ' ');
        java.awt.Event event14 = null;
        boolean boolean17 = nodeViewerData8.mouseEnter(event14, (int) (byte) 0, (int) '#');
        int int18 = nodeViewerData8.getComponentCount();
        java.awt.Cursor cursor19 = nodeViewerData8.getCursor();
        nodeViewerData8.hide();
        int int21 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData8);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(nodeViewerData1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(nodeViewerData8);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 2 + "'", int18 == 2);
        org.junit.Assert.assertNotNull(cursor19);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test507");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        int int6 = nodeViewerData0.getX();
        nodeViewerData0.setName("ToolTipText");
        nodeViewerData0.setAlignmentY((float) 2);
        java.awt.ComponentOrientation componentOrientation11 = null;
        nodeViewerData0.setComponentOrientation(componentOrientation11);
        nodeViewerData0.requestFocus();
        java.awt.Graphics graphics14 = null;
        nodeViewerData0.paintAll(graphics14);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test508");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        javax.swing.plaf.PanelUI panelUI6 = null;
        nodeViewerData0.setUI(panelUI6);
        java.awt.Event event8 = null;
        boolean boolean11 = nodeViewerData0.mouseDrag(event8, 16, (int) '#');
        java.awt.Image image14 = nodeViewerData0.createImage(8, 1);
        java.awt.GraphicsConfiguration graphicsConfiguration15 = nodeViewerData0.getGraphicsConfiguration();
        javax.swing.TransferHandler transferHandler16 = nodeViewerData0.getTransferHandler();
        boolean boolean17 = javax.swing.JComponent.isLightweightComponent((java.awt.Component) nodeViewerData0);
        java.awt.event.ComponentListener componentListener18 = null;
        nodeViewerData0.addComponentListener(componentListener18);
        java.awt.LayoutManager layoutManager20 = null;
        nodeViewerData0.setLayout(layoutManager20);
        boolean boolean22 = nodeViewerData0.isValid();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(image14);
        org.junit.Assert.assertNull(graphicsConfiguration15);
        org.junit.Assert.assertNull(transferHandler16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test509");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.enable(true);
        boolean boolean3 = nodeViewerData0.isMaximumSizeSet();
        nodeViewerData0.addNotify();
        java.awt.Component[] componentArray5 = nodeViewerData0.getComponents();
        javax.swing.JToolTip jToolTip6 = nodeViewerData0.createToolTip();
        boolean boolean7 = nodeViewerData0.getVerifyInputWhenFocusTarget();
        java.awt.Event event8 = null;
        boolean boolean11 = nodeViewerData0.mouseMove(event8, 32, (int) (byte) 100);
        nodeViewerData0.layout();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(componentArray5);
        org.junit.Assert.assertNotNull(jToolTip6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test510");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        javax.accessibility.AccessibleContext accessibleContext1 = nodeViewerData0.getAccessibleContext();
        boolean boolean2 = nodeViewerData0.isBackgroundSet();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData3 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event4 = null;
        boolean boolean7 = nodeViewerData3.mouseDrag(event4, 32, (int) (byte) -1);
        boolean boolean8 = nodeViewerData3.isPaintingTile();
        int int9 = nodeViewerData3.getX();
        java.awt.Insets insets10 = nodeViewerData3.insets();
        java.lang.Object obj12 = nodeViewerData3.getClientProperty((java.lang.Object) (-1.0d));
        java.awt.Rectangle rectangle13 = null;
        nodeViewerData3.scrollRectToVisible(rectangle13);
        java.awt.Rectangle rectangle15 = nodeViewerData3.bounds();
        nodeViewerData0.paintImmediately(rectangle15);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(accessibleContext1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(nodeViewerData3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(insets10);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(rectangle15);
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test511");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        int int6 = nodeViewerData0.getX();
        java.awt.Insets insets7 = nodeViewerData0.insets();
        nodeViewerData0.removeAll();
        java.awt.event.InputMethodListener[] inputMethodListenerArray9 = nodeViewerData0.getInputMethodListeners();
        nodeViewerData0.setOpaque(true);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(insets7);
        org.junit.Assert.assertNotNull(inputMethodListenerArray9);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray9, new java.awt.event.InputMethodListener[] {});
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test512");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.enable(true);
        boolean boolean3 = nodeViewerData0.isMaximumSizeSet();
        java.awt.event.FocusEvent.Cause cause4 = null;
        nodeViewerData0.requestFocus(cause4);
        java.awt.Dimension dimension6 = nodeViewerData0.minimumSize();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData7 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        javax.accessibility.AccessibleContext accessibleContext8 = nodeViewerData7.getAccessibleContext();
        java.awt.LayoutManager layoutManager9 = null;
        nodeViewerData7.setLayout(layoutManager9);
        java.awt.Dimension dimension11 = nodeViewerData7.getMinimumSize();
        java.awt.Dimension dimension12 = nodeViewerData0.getSize(dimension11);
        java.awt.Graphics graphics13 = null;
        nodeViewerData0.print(graphics13);
        boolean boolean15 = nodeViewerData0.getAutoscrolls();
        boolean boolean16 = nodeViewerData0.isFocusTraversalPolicyProvider();
        boolean boolean17 = nodeViewerData0.isValid();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(dimension6);
        org.junit.Assert.assertNotNull(nodeViewerData7);
        org.junit.Assert.assertNotNull(accessibleContext8);
        org.junit.Assert.assertNotNull(dimension11);
        org.junit.Assert.assertNotNull(dimension12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test513");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.enable(true);
        boolean boolean5 = nodeViewerData0.contains((int) (short) 1, (int) ' ');
        java.awt.Event event6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = nodeViewerData0.handleEvent(event6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"id\" because \"evt\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test514");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData1 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int2 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData1);
        int int3 = nodeViewerData1.countComponents();
        boolean boolean4 = nodeViewerData1.isFocusTraversalPolicyProvider();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData5 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event6 = null;
        boolean boolean9 = nodeViewerData5.mouseDrag(event6, 32, (int) (byte) -1);
        boolean boolean10 = nodeViewerData5.isPaintingTile();
        int int11 = nodeViewerData5.getX();
        nodeViewerData5.setName("ToolTipText");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData14 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event15 = null;
        boolean boolean18 = nodeViewerData14.mouseDrag(event15, 32, (int) (byte) -1);
        boolean boolean19 = nodeViewerData14.isPaintingTile();
        int int20 = nodeViewerData14.getX();
        nodeViewerData14.setName("ToolTipText");
        java.awt.Image image23 = null;
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData24 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int25 = nodeViewerData14.checkImage(image23, (java.awt.image.ImageObserver) nodeViewerData24);
        int int26 = nodeViewerData5.getComponentZOrder((java.awt.Component) nodeViewerData24);
        java.awt.event.ComponentListener componentListener27 = null;
        nodeViewerData5.removeComponentListener(componentListener27);
        nodeViewerData5.firePropertyChange("org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", '#', ' ');
        nodeViewerData1.remove((java.awt.Component) nodeViewerData5);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(nodeViewerData1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 2 + "'", int3 == 2);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(nodeViewerData5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData14);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 32 + "'", int25 == 32);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + (-1) + "'", int26 == (-1));
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test515");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData0.enable(true);
        java.awt.event.MouseWheelListener[] mouseWheelListenerArray3 = nodeViewerData0.getMouseWheelListeners();
        java.awt.Event event4 = null;
        boolean boolean7 = nodeViewerData0.mouseEnter(event4, (int) (short) 10, 1);
        java.awt.im.InputMethodRequests inputMethodRequests8 = nodeViewerData0.getInputMethodRequests();
        nodeViewerData0.firePropertyChange("hi!", 'a', 'a');
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData13 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event14 = null;
        boolean boolean17 = nodeViewerData13.mouseDrag(event14, 32, (int) (byte) -1);
        boolean boolean18 = nodeViewerData13.isPaintingTile();
        int int19 = nodeViewerData13.getX();
        java.awt.Insets insets20 = nodeViewerData13.insets();
        nodeViewerData13.removeAll();
        java.awt.event.InputMethodListener[] inputMethodListenerArray22 = nodeViewerData13.getInputMethodListeners();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData23 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData24 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int25 = nodeViewerData23.getComponentZOrder((java.awt.Component) nodeViewerData24);
        java.awt.event.KeyListener keyListener26 = null;
        nodeViewerData23.addKeyListener(keyListener26);
        nodeViewerData23.addNotify();
        nodeViewerData23.requestFocus();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData30 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData30.enable(true);
        java.awt.event.MouseWheelListener[] mouseWheelListenerArray33 = nodeViewerData30.getMouseWheelListeners();
        java.awt.Event event34 = null;
        boolean boolean37 = nodeViewerData30.mouseEnter(event34, (int) (short) 10, 1);
        java.awt.im.InputMethodRequests inputMethodRequests38 = nodeViewerData30.getInputMethodRequests();
        java.awt.ComponentOrientation componentOrientation39 = null;
        nodeViewerData30.setComponentOrientation(componentOrientation39);
        java.awt.Component component41 = nodeViewerData23.add((java.awt.Component) nodeViewerData30);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData42 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData42.enable(true);
        boolean boolean47 = nodeViewerData42.contains((int) (short) 1, (int) ' ');
        java.awt.Event event48 = null;
        boolean boolean51 = nodeViewerData42.mouseEnter(event48, (int) (byte) 0, (int) '#');
        nodeViewerData42.transferFocus();
        nodeViewerData42.firePropertyChange("", (short) 0, (short) (byte) 0);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData57 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Dimension dimension58 = nodeViewerData57.getSize();
        boolean boolean59 = nodeViewerData42.isFocusCycleRoot((java.awt.Container) nodeViewerData57);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData60 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event61 = null;
        boolean boolean64 = nodeViewerData60.mouseDrag(event61, 32, (int) (byte) -1);
        boolean boolean65 = nodeViewerData60.isPaintingTile();
        int int66 = nodeViewerData60.getX();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData67 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event68 = null;
        boolean boolean71 = nodeViewerData67.mouseDrag(event68, 32, (int) (byte) -1);
        boolean boolean72 = nodeViewerData67.isPaintingTile();
        int int73 = nodeViewerData67.getX();
        nodeViewerData67.setEnabled(true);
        java.awt.Color color76 = nodeViewerData67.getBackground();
        java.awt.Point point77 = nodeViewerData67.getLocation();
        java.awt.Component component78 = nodeViewerData60.getComponentAt(point77);
        nodeViewerData57.setLocation(point77);
        java.awt.Point point80 = nodeViewerData30.getLocation(point77);
        boolean boolean81 = nodeViewerData13.contains(point80);
        java.awt.Component component82 = nodeViewerData0.findComponentAt(point80);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(mouseWheelListenerArray3);
        org.junit.Assert.assertArrayEquals(mouseWheelListenerArray3, new java.awt.event.MouseWheelListener[] {});
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(inputMethodRequests8);
        org.junit.Assert.assertNotNull(nodeViewerData13);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(insets20);
        org.junit.Assert.assertNotNull(inputMethodListenerArray22);
        org.junit.Assert.assertArrayEquals(inputMethodListenerArray22, new java.awt.event.InputMethodListener[] {});
        org.junit.Assert.assertNotNull(nodeViewerData23);
        org.junit.Assert.assertNotNull(nodeViewerData24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + (-1) + "'", int25 == (-1));
        org.junit.Assert.assertNotNull(nodeViewerData30);
        org.junit.Assert.assertNotNull(mouseWheelListenerArray33);
        org.junit.Assert.assertArrayEquals(mouseWheelListenerArray33, new java.awt.event.MouseWheelListener[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNull(inputMethodRequests38);
        org.junit.Assert.assertNotNull(component41);
        org.junit.Assert.assertNotNull(nodeViewerData42);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertNotNull(nodeViewerData57);
        org.junit.Assert.assertNotNull(dimension58);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertNotNull(nodeViewerData60);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + false + "'", boolean65 == false);
        org.junit.Assert.assertTrue("'" + int66 + "' != '" + 0 + "'", int66 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData67);
        org.junit.Assert.assertTrue("'" + boolean71 + "' != '" + false + "'", boolean71 == false);
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + false + "'", boolean72 == false);
        org.junit.Assert.assertTrue("'" + int73 + "' != '" + 0 + "'", int73 == 0);
        org.junit.Assert.assertNotNull(color76);
        org.junit.Assert.assertNotNull(point77);
        org.junit.Assert.assertNull(component78);
        org.junit.Assert.assertNotNull(point80);
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + false + "'", boolean81 == false);
        org.junit.Assert.assertNull(component82);
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test516");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData1 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        int int2 = nodeViewerData0.getComponentZOrder((java.awt.Component) nodeViewerData1);
        java.awt.event.KeyListener keyListener3 = null;
        nodeViewerData0.addKeyListener(keyListener3);
        nodeViewerData0.addNotify();
        nodeViewerData0.requestFocus();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData7 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData7.enable(true);
        java.awt.event.MouseWheelListener[] mouseWheelListenerArray10 = nodeViewerData7.getMouseWheelListeners();
        java.awt.Event event11 = null;
        boolean boolean14 = nodeViewerData7.mouseEnter(event11, (int) (short) 10, 1);
        java.awt.im.InputMethodRequests inputMethodRequests15 = nodeViewerData7.getInputMethodRequests();
        java.awt.ComponentOrientation componentOrientation16 = null;
        nodeViewerData7.setComponentOrientation(componentOrientation16);
        java.awt.Component component18 = nodeViewerData0.add((java.awt.Component) nodeViewerData7);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData19 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        nodeViewerData19.enable(true);
        boolean boolean24 = nodeViewerData19.contains((int) (short) 1, (int) ' ');
        java.awt.Event event25 = null;
        boolean boolean28 = nodeViewerData19.mouseEnter(event25, (int) (byte) 0, (int) '#');
        nodeViewerData19.transferFocus();
        nodeViewerData19.firePropertyChange("", (short) 0, (short) (byte) 0);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData34 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Dimension dimension35 = nodeViewerData34.getSize();
        boolean boolean36 = nodeViewerData19.isFocusCycleRoot((java.awt.Container) nodeViewerData34);
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData37 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event38 = null;
        boolean boolean41 = nodeViewerData37.mouseDrag(event38, 32, (int) (byte) -1);
        boolean boolean42 = nodeViewerData37.isPaintingTile();
        int int43 = nodeViewerData37.getX();
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData44 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event45 = null;
        boolean boolean48 = nodeViewerData44.mouseDrag(event45, 32, (int) (byte) -1);
        boolean boolean49 = nodeViewerData44.isPaintingTile();
        int int50 = nodeViewerData44.getX();
        nodeViewerData44.setEnabled(true);
        java.awt.Color color53 = nodeViewerData44.getBackground();
        java.awt.Point point54 = nodeViewerData44.getLocation();
        java.awt.Component component55 = nodeViewerData37.getComponentAt(point54);
        nodeViewerData34.setLocation(point54);
        java.awt.Point point57 = nodeViewerData7.getLocation(point54);
        int int58 = nodeViewerData7.getY();
        nodeViewerData7.remove((int) (short) 0);
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertNotNull(nodeViewerData1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(nodeViewerData7);
        org.junit.Assert.assertNotNull(mouseWheelListenerArray10);
        org.junit.Assert.assertArrayEquals(mouseWheelListenerArray10, new java.awt.event.MouseWheelListener[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(inputMethodRequests15);
        org.junit.Assert.assertNotNull(component18);
        org.junit.Assert.assertNotNull(nodeViewerData19);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(nodeViewerData34);
        org.junit.Assert.assertNotNull(dimension35);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(nodeViewerData37);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 0 + "'", int43 == 0);
        org.junit.Assert.assertNotNull(nodeViewerData44);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 0 + "'", int50 == 0);
        org.junit.Assert.assertNotNull(color53);
        org.junit.Assert.assertNotNull(point54);
        org.junit.Assert.assertNull(component55);
        org.junit.Assert.assertNotNull(point57);
        org.junit.Assert.assertTrue("'" + int58 + "' != '" + 0 + "'", int58 == 0);
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC3RandoopTest1.test517");
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerDataRandoopHelper.createViewer();
        java.awt.Event event1 = null;
        boolean boolean4 = nodeViewerData0.mouseDrag(event1, 32, (int) (byte) -1);
        boolean boolean5 = nodeViewerData0.isPaintingTile();
        int int6 = nodeViewerData0.getX();
        nodeViewerData0.setEnabled(true);
        java.awt.LayoutManager layoutManager9 = null;
        nodeViewerData0.setLayout(layoutManager9);
        nodeViewerData0.firePropertyChange("org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData", (short) -1, (short) -1);
        javax.swing.InputMap inputMap15 = nodeViewerData0.getInputMap();
        org.junit.Assert.assertNotNull(nodeViewerData0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(inputMap15);
    }
}
