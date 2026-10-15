/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jute.compiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class JVectorC1LLMGuidedTreeTest {

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
        assertEquals("    throw new UnsupportedOperationException(\"comparing values is unimplemented\");\n",
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

        assertTrue(!generated.contains("java.util.List values;"));
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

        assertTrue(!generated.contains("System.Collections.Generic.List<int> Values;"));
        assertTrue(generated.contains("a_.StartVector(\"items\");"));
        assertTrue(generated.contains("a_.EndVector(\"items\");"));
    }

    @Test
    public void genCsharpReadMethodDelegatesToReadWrapperWithoutDeclaration() {
        assertEquals(vector.genCsharpReadWrapper("values", "items", false),
                vector.genCsharpReadMethod("values", "items"));
    }

    @Test
    public void generatedMethodNamesUseDistinctLevelsAcrossCalls() {
        String first = vector.genJavaReadWrapper("first", "tag", false);
        String second = vector.genJavaReadWrapper("second", "tag", false);

        assertTrue(first.contains("vidx1"));
        assertTrue(second.contains("vidx1"));
        assertTrue(!first.contains("vidx2"));
        assertTrue(!second.contains("vidx2"));
    }

    @Test
    public void nullElementIsRejected() {
        try {
            new JVector(null);
            fail("Expected a null element type to be rejected");
        } catch (NullPointerException expected) {
            // Expected: construction needs the element type to derive vector metadata.
        }
    }
}
