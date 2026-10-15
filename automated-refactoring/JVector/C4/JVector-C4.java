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

/**
 *
 */
public class JVector extends JCompType {

    private static final String OPEN_BLOCK = "    {\n";
    private static final String END_CALL_SUFFIX = "\");\n";
    private static final String IF_PREFIX = "      if (";
    private static final String NOT_NULL_BLOCK = "!= null) {";
    private static final String BODY_INDENT = "          ";
    private static final String INNER_BODY_INDENT = "            ";
    private static final String INNER_BLOCK_END = "          }\n";
    private static final String BLOCK_END = "      }\n";
    private static final String OUTER_BLOCK_END = "    }\n";

    private static int level = 0;

    private static String getId(String id) {
        return id + getLevel();
    }

    private static String getLevel() {
        return Integer.toString(level);
    }

    private static void incrLevel() {
        level++;
    }

    private static void decrLevel() {
        level--;
    }

    private JType mElement;

    /**
     * Creates a new instance of JVector.
     */
    public JVector(JType t) {
        super("struct " + extractVectorName(t), " ::std::vector<" + t.getCppType() + ">", "System.Collections.Generic.List<" + t.getCsharpType() + ">", "java.util.List<" + t.getJavaType() + ">", "Vector",
                "System.Collections.Generic.List<" + t.getCsharpType() + ">", "java.util.ArrayList<" + t.getJavaType() + ">");
        mElement = t;
    }

    @Override
    public String getSignature() {
        return "[" + mElement.getSignature() + "]";
    }

    @Override
    public String genJavaCompareTo(String fname) {
        return "    throw new UnsupportedOperationException(\"comparing "
                + fname + " is unimplemented\");\n";
    }

    @Override
    public String genJavaReadWrapper(String fname, String tag, boolean decl) {
        StringBuilder ret = new StringBuilder("");
        if (decl) {
            ret.append("      java.util.List " + fname + ";\n");
        }
        ret.append(OPEN_BLOCK);
        incrLevel();
        ret.append("      Index " + getId("vidx") + " = a_.startVector(\"" + tag + END_CALL_SUFFIX);
        ret.append(IF_PREFIX + getId("vidx") + NOT_NULL_BLOCK);
        ret.append(BODY_INDENT + fname + "=new java.util.ArrayList<" + mElement.getJavaType() + ">();\n");
        ret.append(BODY_INDENT + "for (; !" + getId("vidx") + ".done(); " + getId("vidx") + ".incr()) {\n");
        ret.append(mElement.genJavaReadWrapper(getId("e"), getId("e"), true));
        ret.append(INNER_BODY_INDENT + fname + ".add(" + getId("e") + ");\n");
        ret.append(INNER_BLOCK_END);
        ret.append(BLOCK_END);
        ret.append("    a_.endVector(\"" + tag + END_CALL_SUFFIX);
        decrLevel();
        ret.append(OUTER_BLOCK_END);
        return ret.toString();
    }

    @Override
    public String genJavaReadMethod(String fname, String tag) {
        return genJavaReadWrapper(fname, tag, false);
    }

    @Override
    public String genJavaWriteWrapper(String fname, String tag) {
        StringBuilder ret = new StringBuilder(OPEN_BLOCK);
        incrLevel();
        ret.append("      a_.startVector(" + fname + ",\"" + tag + END_CALL_SUFFIX);
        ret.append(IF_PREFIX + fname + NOT_NULL_BLOCK);
        ret.append(BODY_INDENT + "int " + getId("len") + " = " + fname + ".size();\n");
        ret.append(BODY_INDENT + "for(int " + getId("vidx") + " = 0; " + getId("vidx") + "<" + getId("len") + "; " + getId("vidx") + "++) {\n");
        ret.append(INNER_BODY_INDENT + mElement.getJavaWrapperType() + " " + getId("e") + " = (" + mElement.getJavaWrapperType() + ") " + fname + ".get(" + getId("vidx") + ");\n");
        ret.append(mElement.genJavaWriteWrapper(getId("e"), getId("e")));
        ret.append(INNER_BLOCK_END);
        ret.append(BLOCK_END);
        ret.append("      a_.endVector(" + fname + ",\"" + tag + END_CALL_SUFFIX);
        ret.append(OUTER_BLOCK_END);
        decrLevel();
        return ret.toString();
    }

    @Override
    public String genJavaWriteMethod(String fname, String tag) {
        return genJavaWriteWrapper(fname, tag);
    }

    public JType getElementType() {
        return mElement;
    }

    @Override
    public String genCsharpWriteWrapper(String fname, String tag) {
        StringBuilder ret = new StringBuilder(OPEN_BLOCK);
        incrLevel();
        ret.append("      a_.StartVector(" + capitalize(fname) + ",\"" + tag + END_CALL_SUFFIX);
        ret.append(IF_PREFIX + capitalize(fname) + NOT_NULL_BLOCK);
        ret.append(BODY_INDENT + "int " + getId("len") + " = " + capitalize(fname) + ".Count;\n");
        ret.append(BODY_INDENT + "for(int " + getId("vidx") + " = 0; " + getId("vidx") + "<" + getId("len") + "; " + getId("vidx") + "++) {\n");
        ret.append(INNER_BODY_INDENT + mElement.getCsharpWrapperType() + " " + getId("e") + " = (" + mElement.getCsharpWrapperType() + ") " + capitalize(fname) + "[" + getId("vidx") + "];\n");
        ret.append(mElement.genCsharpWriteWrapper(getId("e"), getId("e")));
        ret.append(INNER_BLOCK_END);
        ret.append(BLOCK_END);
        ret.append("      a_.EndVector(" + capitalize(fname) + ",\"" + tag + END_CALL_SUFFIX);
        ret.append(OUTER_BLOCK_END);
        decrLevel();
        return ret.toString();
    }

    @Override
    String genCsharpWriteMethod(String fname, String tag) {
        return genCsharpWriteWrapper(fname, tag);
    }

    @Override
    public String genCsharpReadWrapper(String fname, String tag, boolean decl) {
        StringBuilder ret = new StringBuilder("");
        if (decl) {
            ret.append("      System.Collections.Generic.List<" + mElement.getCsharpType() + "> " + capitalize(fname) + ";\n");
        }
        ret.append(OPEN_BLOCK);
        incrLevel();
        ret.append("      IIndex " + getId("vidx") + " = a_.StartVector(\"" + tag + END_CALL_SUFFIX);
        ret.append(IF_PREFIX + getId("vidx") + NOT_NULL_BLOCK);
        ret.append(BODY_INDENT + capitalize(fname) + "=new System.Collections.Generic.List<" + mElement.getCsharpType() + ">();\n");
        ret.append(BODY_INDENT + "for (; !" + getId("vidx") + ".Done(); " + getId("vidx") + ".Incr()) {\n");
        ret.append(mElement.genCsharpReadWrapper(getId("e"), getId("e"), true));
        ret.append(INNER_BODY_INDENT + capitalize(fname) + ".Add(" + getId("e") + ");\n");
        ret.append(INNER_BLOCK_END);
        ret.append(BLOCK_END);
        ret.append("    a_.EndVector(\"" + tag + END_CALL_SUFFIX);
        decrLevel();
        ret.append(OUTER_BLOCK_END);
        return ret.toString();
    }

    @Override
    String genCsharpReadMethod(String fname, String tag) {
        return genCsharpReadWrapper(fname, tag, false);
    }

    static String extractVectorName(JType jvType) {
        return JRecord.extractMethodSuffix(jvType) + "_vector";
    }
}
