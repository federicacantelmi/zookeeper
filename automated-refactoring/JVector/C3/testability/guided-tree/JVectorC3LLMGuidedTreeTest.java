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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class JVectorC3LLMGuidedTreeTest {

    private JType element;
    private JVector vector;

    @Before
    public void setUp() {
        element = mock(JType.class);
        when(element.getCppType()).thenReturn("int32_t");
        when(element.getCsharpType()).thenReturn("int");
        when(element.getJavaType()).thenReturn("int");

        when(element.genCsharpReadWrapper(anyString(), anyString(), eq(true)))
                .thenAnswer(invocation -> {
                    String name = (String) invocation.getArguments()[0];
                    String tag = (String) invocation.getArguments()[1];
                    return "            int " + name + " = a_.ReadInt(\"" + tag + "\");\n";
                });

        vector = new JVector(element);
    }

    @Test
    public void genCsharpReadWrapperIncludesDeclarationAndReadsElements() {
        String generated = vector.genCsharpReadWrapper("values", "items", true);

        assertTrue(generated.contains(
                "System.Collections.Generic.List<int> Values;\n"));
        assertTrue(generated.contains("IIndex "));
        assertTrue(generated.contains("a_.StartVector(\"items\");"));
        assertTrue(generated.contains("if ("));
        assertTrue(generated.contains("!= null) {"));
        assertTrue(generated.contains(
                "Values=new System.Collections.Generic.List<int>();"));

        String index = findVectorIndex(generated, "items");
        assertTrue(generated.contains(
                "for (; !" + index + ".Done(); " + index + ".Incr()) {"));

        ArgumentCaptor<String> elementName = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> elementTag = ArgumentCaptor.forClass(String.class);
        verify(element).genCsharpReadWrapper(
                elementName.capture(), elementTag.capture(), eq(true));

        assertTrue(elementName.getValue().matches("e\\d+"));
        assertEquals(elementName.getValue(), elementTag.getValue());
        assertTrue(generated.contains("int " + elementName.getValue()
                + " = a_.ReadInt(\"" + elementTag.getValue() + "\");"));
        assertTrue(generated.contains("Values.Add(" + elementName.getValue() + ");"));
        assertTrue(generated.contains("a_.EndVector(\"items\");"));
    }

    @Test
    public void genCsharpReadWrapperOmitsDeclarationWhenNotRequested() {
        String generated = vector.genCsharpReadWrapper("values", "items", false);

        assertFalse(generated.contains(
                "System.Collections.Generic.List<int> Values;\n"));
        assertTrue(generated.contains(
                "Values=new System.Collections.Generic.List<int>();"));
        assertTrue(generated.contains("a_.StartVector(\"items\");"));
        assertTrue(generated.contains("a_.EndVector(\"items\");"));

        String index = findVectorIndex(generated, "items");
        assertTrue(generated.contains(
                "for (; !" + index + ".Done(); " + index + ".Incr()) {"));
    }

    @Test
    public void genCsharpReadMethodDelegatesToWrapperWithoutDeclaration() {
        assertEquals(
                vector.genCsharpReadWrapper("values", "items", false),
                vector.genCsharpReadMethod("values", "items"));
    }

    private String findVectorIndex(String generated, String tag) {
        Pattern pattern = Pattern.compile(
                "IIndex (vidx\\d+) = a_\\.StartVector\\(\""
                        + Pattern.quote(tag) + "\"\\);");
        Matcher matcher = pattern.matcher(generated);
        assertTrue("Generated code should declare a vector index", matcher.find());
        return matcher.group(1);
    }
}