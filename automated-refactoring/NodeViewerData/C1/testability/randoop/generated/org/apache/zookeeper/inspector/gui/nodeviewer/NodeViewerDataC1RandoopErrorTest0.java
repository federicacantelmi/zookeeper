package org.apache.zookeeper.inspector.gui.nodeviewer;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodeViewerDataC1RandoopErrorTest0 {

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
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "NodeViewerDataC1RandoopErrorTest0.test1");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData nodeViewerData0 = new org.apache.zookeeper.inspector.gui.nodeviewer.NodeViewerData();
    }
}

