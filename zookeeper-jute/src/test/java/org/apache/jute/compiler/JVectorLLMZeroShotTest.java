package org.apache.jute.compiler;

import static org.junit.Assert.*;

import org.junit.Test;

public class JVectorLLMZeroShotTest {

    private JVector newIntVector() {
        return new JVector(new JInt());
    }

    @Test
    public void constructorStoresElementTypeAndBuildsSignature() {
        JInt element = new JInt();
        JVector vector = new JVector(element);

        assertSame(element, vector.getElementType());
        assertEquals("[" + element.getSignature() + "]", vector.getSignature());
    }

    @Test
    public void extractVectorNameAppendsVectorSuffix() {
        assertTrue(JVector.extractVectorName(new JInt()).endsWith("_vector"));
    }

    @Test
    public void genJavaCompareToReturnsUnsupportedOperationCode() {
        assertEquals(
                "    throw new UnsupportedOperationException(\"comparing values is unimplemented\");\n",
                newIntVector().genJavaCompareTo("values"));
    }

    @Test
    public void genJavaReadWrapperWithDeclarationIncludesVectorReadAndDeclaration() {
        String generated = newIntVector().genJavaReadWrapper("values", "values-tag", true);

        assertTrue(generated.contains("java.util.List values;"));
        assertTrue(generated.contains("a_.startVector(\"values-tag\")"));
        assertTrue(generated.contains("new java.util.ArrayList<"));
        assertTrue(generated.contains(".done()"));
        assertTrue(generated.contains(".incr()"));
        assertTrue(generated.contains("values.add(e1)"));
        assertTrue(generated.contains("a_.endVector(\"values-tag\")"));
    }

    @Test
    public void genJavaReadWrapperWithoutDeclarationOmitsDeclaration() {
        String generated = newIntVector().genJavaReadWrapper("values", "tag", false);

        assertFalse(generated.contains("java.util.List values;"));
        assertTrue(generated.contains("a_.startVector(\"tag\")"));
        assertTrue(generated.contains("a_.endVector(\"tag\")"));
    }

    @Test
    public void genJavaReadMethodDelegatesToReadWrapper() {
        JVector vector = newIntVector();

        assertEquals(
                vector.genJavaReadWrapper("values", "tag", false),
                vector.genJavaReadMethod("values", "tag"));
    }

    @Test
    public void genJavaWriteWrapperGeneratesVectorLoopAndElementWrites() {
        JVector vector = newIntVector();
        String generated = vector.genJavaWriteWrapper("values", "tag");

        assertTrue(generated.contains("a_.startVector(values,\"tag\")"));
        assertTrue(generated.contains("values.size()"));
        assertTrue(generated.contains("values.get(vidx1)"));
        assertTrue(generated.contains(vector.getElementType().getJavaWrapperType()));
        assertTrue(generated.contains("a_.endVector(values,\"tag\")"));
    }

    @Test
    public void genJavaWriteMethodDelegatesToWriteWrapper() {
        JVector vector = newIntVector();

        assertEquals(
                vector.genJavaWriteWrapper("values", "tag"),
                vector.genJavaWriteMethod("values", "tag"));
    }

    @Test
    public void genCsharpWriteWrapperGeneratesVectorLoopAndElementWrites() {
        JVector vector = newIntVector();
        String generated = vector.genCsharpWriteWrapper("values", "tag");

        assertTrue(generated.contains("a_.StartVector(Values,\"tag\")"));
        assertTrue(generated.contains("Values.Count"));
        assertTrue(generated.contains("Values[vidx1]"));
        assertTrue(generated.contains(vector.getElementType().getCsharpWrapperType()));
        assertTrue(generated.contains("a_.EndVector(Values,\"tag\")"));
    }

    @Test
    public void genCsharpWriteMethodDelegatesToWriteWrapper() {
        JVector vector = newIntVector();

        assertEquals(
                vector.genCsharpWriteWrapper("values", "tag"),
                vector.genCsharpWriteMethod("values", "tag"));
    }

    @Test
    public void genCsharpReadWrapperWithDeclarationIncludesVectorReadAndDeclaration() {
        String generated = newIntVector().genCsharpReadWrapper("values", "tag", true);

        assertTrue(generated.contains(
                "System.Collections.Generic.List<" +
                        newIntVector().getElementType().getCsharpType() + "> Values;"));
        assertTrue(generated.contains("a_.StartVector(\"tag\")"));
        assertTrue(generated.contains("new System.Collections.Generic.List<"));
        assertTrue(generated.contains(".Done()"));
        assertTrue(generated.contains(".Incr()"));
        assertTrue(generated.contains("Values.Add(e1)"));
        assertTrue(generated.contains("a_.EndVector(\"tag\")"));
    }

    @Test
    public void genCsharpReadWrapperWithoutDeclarationOmitsDeclaration() {
        String generated = newIntVector().genCsharpReadWrapper("values", "tag", false);

        assertFalse(generated.contains("System.Collections.Generic.List<" + newIntVector().getElementType().getCsharpType() + "> Values;"));
        assertTrue(generated.contains("a_.StartVector(\"tag\")"));
        assertTrue(generated.contains("a_.EndVector(\"tag\")"));
    }

    @Test
    public void genCsharpReadMethodDelegatesToReadWrapper() {
        JVector vector = newIntVector();

        assertEquals(
                vector.genCsharpReadWrapper("values", "tag", false),
                vector.genCsharpReadMethod("values", "tag"));
    }

    @Test
    public void nestedVectorGenerationUsesNestedLevelIdentifiersAndRestoresLevel() {
        JVector nested = new JVector(newIntVector());

        String generated = nested.genJavaReadWrapper("values", "tag", false);

        assertTrue(generated.contains("vidx1"));
        assertTrue(generated.contains("vidx2"));

        String subsequent = newIntVector().genJavaReadWrapper("values", "tag", false);
        assertTrue(subsequent.contains("vidx1"));
        assertFalse(subsequent.contains("vidx2"));
    }
}