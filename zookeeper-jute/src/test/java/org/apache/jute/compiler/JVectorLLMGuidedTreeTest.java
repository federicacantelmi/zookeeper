// ###Test START##
package org.apache.jute.compiler;

import static org.junit.Assert.*;

import org.junit.Test;

public class JVectorLLMGuidedTreeTest {

    private JVector newIntVector() {
        return new JVector(new JInt());
    }

    @Test
    public void constructorRejectsNullElementType() {
        try {
            new JVector(null);
            fail("Expected a NullPointerException for a null element type");
        } catch (NullPointerException expected) {
            // The constructor needs the element type to build its type metadata.
        }
    }

    @Test
    public void javaReadWrapperGuardsNullVectorAndAlwaysEndsVector() {
        String generated = newIntVector().genJavaReadWrapper("values", "tag", false);

        assertTrue(generated.contains("if (vidx1!= null)"));
        assertTrue(generated.contains("values=new java.util.ArrayList<"));
        assertTrue(generated.contains("}\n    a_.endVector(\"tag\");"));
    }

    @Test
    public void javaWriteWrapperGuardsNullVectorAndEndsItAfterTheGuard() {
        String generated = newIntVector().genJavaWriteWrapper("values", "tag");

        assertTrue(generated.contains("if (values!= null)"));
        assertTrue(generated.contains("values.size()"));
        assertTrue(generated.contains("}\n      a_.endVector(values,\"tag\");"));
    }

    @Test
    public void csharpReadWrapperGuardsNullVectorAndAlwaysEndsVector() {
        String generated = newIntVector().genCsharpReadWrapper("values", "tag", false);

        assertTrue(generated.contains("if (vidx1!= null)"));
        assertTrue(generated.contains("Values=new System.Collections.Generic.List<"));
        assertTrue(generated.contains("}\n    a_.EndVector(\"tag\");"));
    }

    @Test
    public void csharpWriteWrapperGuardsNullVectorAndEndsItAfterTheGuard() {
        String generated = newIntVector().genCsharpWriteWrapper("values", "tag");

        assertTrue(generated.contains("if (Values!= null)"));
        assertTrue(generated.contains("Values.Count"));
        assertTrue(generated.contains("}\n      a_.EndVector(Values,\"tag\");"));
    }

    @Test
    public void nestedJavaWriteGenerationUsesNestedIdentifiersAndRestoresLevel() {
        JVector nested = new JVector(newIntVector());

        String generated = nested.genJavaWriteWrapper("values", "tag");
        assertTrue(generated.contains("len1"));
        assertTrue(generated.contains("vidx1"));
        assertTrue(generated.contains("len2"));
        assertTrue(generated.contains("vidx2"));

        String subsequent = newIntVector().genJavaWriteWrapper("values", "tag");
        assertTrue(subsequent.contains("vidx1"));
        assertFalse(subsequent.contains("vidx2"));
    }

    @Test
    public void nestedCsharpReadGenerationUsesNestedIdentifiersAndRestoresLevel() {
        JVector nested = new JVector(newIntVector());

        String generated = nested.genCsharpReadWrapper("values", "tag", false);
        assertTrue(generated.contains("vidx1"));
        assertTrue(generated.contains("vidx2"));

        String subsequent = newIntVector().genCsharpReadWrapper("values", "tag", false);
        assertTrue(subsequent.contains("vidx1"));
        assertFalse(subsequent.contains("vidx2"));
    }

    @Test
    public void nestedCsharpWriteGenerationUsesNestedIdentifiersAndRestoresLevel() {
        JVector nested = new JVector(newIntVector());

        String generated = nested.genCsharpWriteWrapper("values", "tag");
        assertTrue(generated.contains("len1"));
        assertTrue(generated.contains("vidx1"));
        assertTrue(generated.contains("len2"));
        assertTrue(generated.contains("vidx2"));

        String subsequent = newIntVector().genCsharpWriteWrapper("values", "tag");
        assertTrue(subsequent.contains("vidx1"));
        assertFalse(subsequent.contains("vidx2"));
    }

    @Test
    public void javaCompareToIncludesSuppliedFieldName() {
        assertEquals(
                "    throw new UnsupportedOperationException(\"comparing items is unimplemented\");\n",
                newIntVector().genJavaCompareTo("items"));
    }
}
// ###Test END##