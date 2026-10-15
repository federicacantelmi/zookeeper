/*
 * Plan (pseudocode):
 * 1. List the JVector methods that can be called from this package:
 *    constructor; getSignature; genJavaCompareTo; Java read/write wrappers and
 *    methods; getElementType; C# read/write wrappers and package-private
 *    methods; extractVectorName.
 * 2. Mock a JType element and stub the type metadata and generated snippets
 *    needed by each generator. Create a fresh JVector in each test setup.
 * 3. Test element retention, signature formatting, and the unsupported
 *    comparison output.
 * 4. Test Java and C# read/write generation, including declarations, vector
 *    calls, null checks, collection setup, loops, element snippets, and closing
 *    calls. Compare each method to its corresponding wrapper.
 * 5. Check identifier stability across independent calls and distinct levels
 *    when vectors are nested.
 * 6. Check the constructor's null-element failure.
 * 7. Prefer assertions against generated output and omit tests with no
 *    meaningful observable behavior.
 */

package org.apache.jute.compiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class JVectorC4LLMGuidedTreeTest {

    private JType element;
    private JVector vector;

    @Before
    public void setUp() {
        element = mock(JType.class);
        when(element.getCppType()).thenReturn("int32_t");
        when(element.getCsharpType()).thenReturn("int");
        when(element.getJavaType()).thenReturn("int");
        when(element.getSignature()).thenReturn("i");
        when(element.getJavaWrapperType()).thenReturn("Integer");
        when(element.getCsharpWrapperType()).thenReturn("int");
        when(element.genJavaReadWrapper("e1", "e1", true))
                .thenReturn("            int e1 = a_.readInt(\"e1\");\n");
        when(element.genJavaWriteWrapper("e1", "e1"))
                .thenReturn("            a_.writeInt(e1, \"e1\");\n");
        when(element.genCsharpReadWrapper("e1", "e1", true))
                .thenReturn("            int e1 = a_.ReadInt(\"e1\");\n");
        when(element.genCsharpWriteWrapper("e1", "e1"))
                .thenReturn("            a_.WriteInt(e1, \"e1\");\n");

        vector = new JVector(element);
    }

    @Test
    public void constructorRetainsElementType() {
        assertSame(element, vector.getElementType());
    }

    @Test
    public void getSignatureWrapsElementSignature() {
        assertEquals("[i]", vector.getSignature());
    }

    @Test
    public void genJavaCompareToReportsUnsupportedComparison() {
        assertEquals(
                "    throw new UnsupportedOperationException(\"comparing "
                        + "values is unimplemented\");\n",
                vector.genJavaCompareTo("values"));
    }

    @Test
    public void genJavaReadWrapperIncludesDeclarationAndElementRead() {
        String generated = vector.genJavaReadWrapper("values", "items", true);

        assertTrue(generated.contains("java.util.List values;\n"));
        assertTrue(generated.contains("a_.startVector(\"items\");"));
        assertTrue(generated.contains("if (vidx1!= null) {"));
        assertTrue(generated.contains("new java.util.ArrayList<int>()"));
        assertTrue(generated.contains("for (; !vidx1.done(); vidx1.incr())"));
        assertTrue(generated.contains("a_.readInt(\"e1\")"));
        assertTrue(generated.contains("values.add(e1);"));
        assertTrue(generated.contains("a_.endVector(\"items\");"));
    }

    @Test
    public void genJavaReadWrapperOmitsDeclarationWhenNotRequested() {
        String generated = vector.genJavaReadWrapper("values", "items", false);

        assertFalse(generated.contains("java.util.List values;"));
        assertTrue(generated.contains("a_.startVector(\"items\");"));
        assertTrue(generated.contains("a_.endVector(\"items\");"));
    }

    @Test
    public void genJavaReadMethodDelegatesToReadWrapperWithoutDeclaration() {
        assertEquals(vector.genJavaReadWrapper("values", "items", false),
                vector.genJavaReadMethod("values", "items"));
    }

    @Test
    public void genJavaWriteWrapperIncludesLoopAndElementWrite() {
        String generated = vector.genJavaWriteWrapper("values", "items");

        assertTrue(generated.contains("a_.startVector(values,\"items\");"));
        assertTrue(generated.contains("if (values!= null) {"));
        assertTrue(generated.contains("int len1 = values.size();"));
        assertTrue(generated.contains("values.get(vidx1)"));
        assertTrue(generated.contains("a_.writeInt(e1, \"e1\")"));
        assertTrue(generated.contains("a_.endVector(values,\"items\");"));
    }

    @Test
    public void genJavaWriteMethodDelegatesToWriteWrapper() {
        assertEquals(vector.genJavaWriteWrapper("values", "items"),
                vector.genJavaWriteMethod("values", "items"));
    }

    @Test
    public void genCsharpWriteWrapperUsesCapitalizedFieldName() {
        String generated = vector.genCsharpWriteWrapper("values", "items");

        assertTrue(generated.contains("a_.StartVector(Values,\"items\");"));
        assertTrue(generated.contains("if (Values!= null) {"));
        assertTrue(generated.contains("int len1 = Values.Count;"));
        assertTrue(generated.contains("Values[vidx1]"));
        assertTrue(generated.contains("a_.WriteInt(e1, \"e1\")"));
        assertTrue(generated.contains("a_.EndVector(Values,\"items\");"));
    }

    @Test
    public void genCsharpWriteMethodDelegatesToWriteWrapper() {
        assertEquals(vector.genCsharpWriteWrapper("values", "items"),
                vector.genCsharpWriteMethod("values", "items"));
    }

    @Test
    public void genCsharpReadWrapperIncludesDeclarationAndElementRead() {
        String generated = vector.genCsharpReadWrapper("values", "items", true);

        assertTrue(generated.contains(
                "System.Collections.Generic.List<int> Values;\n"));
        assertTrue(generated.contains("a_.StartVector(\"items\");"));
        assertTrue(generated.contains("if (vidx1!= null) {"));
        assertTrue(generated.contains(
                "new System.Collections.Generic.List<int>()"));
        assertTrue(generated.contains("for (; !vidx1.Done(); vidx1.Incr())"));
        assertTrue(generated.contains("a_.ReadInt(\"e1\")"));
        assertTrue(generated.contains("Values.Add(e1);"));
        assertTrue(generated.contains("a_.EndVector(\"items\");"));
    }

    @Test
    public void genCsharpReadWrapperOmitsDeclarationWhenNotRequested() {
        String generated = vector.genCsharpReadWrapper("values", "items", false);

        assertFalse(generated.contains(
                "System.Collections.Generic.List<int> Values;"));
        assertTrue(generated.contains("a_.StartVector(\"items\");"));
        assertTrue(generated.contains("a_.EndVector(\"items\");"));
    }

    @Test
    public void genCsharpReadMethodDelegatesToReadWrapperWithoutDeclaration() {
        assertEquals(vector.genCsharpReadWrapper("values", "items", false),
                vector.genCsharpReadMethod("values", "items"));
    }

    @Test
    public void generatedIdentifiersAreStableAcrossIndependentCalls() {
        String first = vector.genJavaReadWrapper("first", "tag", false);
        String second = vector.genJavaReadWrapper("second", "tag", false);

        assertTrue(first.contains("vidx1"));
        assertTrue(second.contains("vidx1"));
        assertFalse(first.contains("vidx2"));
        assertFalse(second.contains("vidx2"));
    }

    @Test
    public void nestedVectorsUseDistinctIdentifierLevels() {
        when(element.genJavaReadWrapper("e2", "e2", true))
                .thenReturn("            int e2 = a_.readInt(\"e2\");\n");

        JVector innerVector = new JVector(element);
        JVector outerVector = new JVector(innerVector);

        String generated = outerVector.genJavaReadWrapper("values", "items", false);

        assertTrue(generated.contains("vidx1"));
        assertTrue(generated.contains("vidx2"));
        assertTrue(generated.contains("a_.readInt(\"e2\")"));
    }

    @Test
    public void nullElementIsRejected() {
        try {
            new JVector(null);
            fail("Expected a null element type to be rejected");
        } catch (NullPointerException expected) {
            // Construction needs an element type to derive vector metadata.
        }
    }
}
