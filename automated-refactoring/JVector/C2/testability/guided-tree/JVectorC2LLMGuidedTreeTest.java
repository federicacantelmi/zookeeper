/*
 * Plan (pseudocode):
 * 1. Create a mocked JType element and stub the metadata and generated element
 *    read/write snippets used by JVector; create a fresh JVector for each test.
 * 2. Check the basic accessors and value-generation methods: element identity,
 *    signature formatting, and the unsupported Java comparison message.
 * 3. For each Java and C# read/write generator, verify its output contains the
 *    expected vector calls, null check, collection setup, loop, element operation,
 *    and closing call. Check optional declarations both enabled and disabled.
 * 4. Verify each read/write method delegates to its corresponding wrapper by
 *    comparing the complete generated strings.
 * 5. Exercise repeated calls and nested vectors to check generated identifiers
 *    are reused between independent calls and increase at nested levels.
 * 6. Verify constructing a vector with a null element fails with a
 *    NullPointerException.
 * 7. Keep assertions focused on observable output and avoid redundant checks.
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

public class JVectorC2LLMGuidedTreeTest {

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
                "    throw new UnsupportedOperationException(\"comparing values is unimplemented\");\n",
                vector.genJavaCompareTo("values"));
    }

    @Test
    public void genJavaReadWrapperIncludesOptionalDeclarationAndElementRead() {
        String generated = vector.genJavaReadWrapper("values", "items", true);

        assertTrue(generated.contains("java.util.List values;\n"));
        assertTrue(generated.contains("a_.startVector(\"items\");"));
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
    public void genCsharpReadWrapperIncludesOptionalDeclarationAndElementRead() {
        String generated = vector.genCsharpReadWrapper("values", "items", true);

        assertTrue(generated.contains("System.Collections.Generic.List<int> Values;\n"));
        assertTrue(generated.contains("a_.StartVector(\"items\");"));
        assertTrue(generated.contains("new System.Collections.Generic.List<int>()"));
        assertTrue(generated.contains("for (; !vidx1.Done(); vidx1.Incr())"));
        assertTrue(generated.contains("a_.ReadInt(\"e1\")"));
        assertTrue(generated.contains("Values.Add(e1);"));
        assertTrue(generated.contains("a_.EndVector(\"items\");"));
    }

    @Test
    public void genCsharpReadWrapperOmitsDeclarationWhenNotRequested() {
        String generated = vector.genCsharpReadWrapper("values", "items", false);

        assertFalse(generated.contains("System.Collections.Generic.List<int> Values;"));
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
            // Construction requires an element type to derive vector metadata.
        }
    }
}
