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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class JVectorBlackBoxTest {

    /*
    * Unita': costruzione di un vettore.
    * Classe di equivalenza: JInt.
    * Oracolo: costruzione completata correttamente.
    */
    @Test
    public void constructVectorPrimitiveType_TC01() {
        JType elementType = new JInt();
        JVector vector = new JVector(elementType);
        assertNotNull("Il vettore deve essere non nullo.", vector);
    }

    /*
    * Unita': costruzione di un vettore.
    * Classe di equivalenza: JString.
    * Oracolo: costruzione completata correttamente.
    */
    @Test
    public void constructVectorCompositeType_TC02() {
        JType elementType = new JString();
        JVector vector = new JVector(elementType);
        assertNotNull("Il vettore deve essere non nullo.", vector);
    }

    /*
    * Unita': recupero del tipo dell'elemento del vettore.
    * Classe di equivalenza: JInt.
    * Oracolo: JInt.
    */
    @Test
    public void returnCorrectPrimitiveType_TC03() {
        JType elementType = new JInt();
        JVector vector = new JVector(elementType);
        JType returnedType = vector.getElementType();
        assertSame("getElementType() deve restituire lo stesso tipo primitivo fornito al costruttore", elementType, returnedType);
    }

    /*
    * Unita': recupero del tipo dell'elemento del vettore.
    * Classe di equivalenza: JString.
    * Oracolo: JString.
    */
    @Test
    public void returnCorrectCompositeType_TC04() {
        JType elementType = new JString();
        JVector vector = new JVector(elementType);
        JType returnedType = vector.getElementType();
        assertSame("getElementType() deve restituire lo stesso tipo composto fornito al costruttore", elementType, returnedType);
    }

    /*
    * Unita': generazione della firma di un vettore.
    * Classe di equivalenza: JVector(JInt).
    * Oracolo: [firma(JInt)].
    */
    @Test
    public void returnSignatureSimpleVector_TC05() {
        JType elementType = new JInt();
        JVector vector = new JVector(elementType);
        String signature = vector.getSignature();
        String expectedSignature = "["+elementType.getSignature()+"]";
        assertEquals("La firma del vettore deve racchiudere tra parentesi quadre la firma dell'elemento", expectedSignature, signature);
    }

    /*
    * Unita': generazione della firma di un vettore.
    * Classe di equivalenza: JVector(JVector(JInt)) .
    * Oracolo: [firma(JVector(Jint))].
    */
    @Test
    public void returnSignatureNestedVector_TC06() {
        JType elementType = new JInt();
        JVector innerVector = new JVector(elementType);
        // si costruisce il vettore passando come elemento il vettore interno
        JVector vector = new JVector(innerVector);
        String signature = vector.getSignature();
        String expectedSignature = "["+innerVector.getSignature()+"]";
        assertEquals("La firma del vettore deve racchiudere tra parentesi quadre la firma del vettore interno", expectedSignature, signature);
    }

    /* Funzione ausiliaria che verifica match tra stringa fornita e codice */
    private Matcher findMatch(String code, String regex, String failureMessage) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        assertTrue(failureMessage, matcher.find());
        return matcher;
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper Java, JInt, true.
    * Oracolo: codice generato, dichiarazione presente, vettore di interi inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadOfIntWithDecl_TC07() {
        JVector vector = new JVector(new JInt());
        String code = vector.genJavaReadWrapper("values", "items", true);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        /*
            - \\ : serve a "proteggere" il punto (.) perche' in regex significa "qualsiasi carattere"
            - \s+ : indica che ci devono essere uno o piu' spazi
            - ([a-zA-Z_]\\w*) : e' il "gruppo di cattura" del nome della variabile
            - \s* : gestisce eventuali spazi prima del punto e virgola
        */
        String string = "java\\.util\\.List\\s+([a-zA-Z_]\\w*)\\s*;";
        Matcher matcher = findMatch(code, string, "Con decl=true deve essere presente la dichiarazione della variabile");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        assertTrue("Il vettore di interi deve essere inizializzato come ArrayList<Integer>", code.contains(var + "=new java.util.ArrayList<Integer>();"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper C#, JInt, true.
    * Oracolo: codice generato, dichiarazione presente, vettore di interi inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadOfIntWithDecl_TC08() {
        JVector vector = new JVector(new JInt());
        String code = vector.genCsharpReadWrapper("values", "items", true);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "System\\.Collections\\.Generic\\.List<int>\\s+([a-zA-Z_]\\w*)\\s*;";
        Matcher matcher = findMatch(code, string, "Con decl=true deve essere presente la dichiarazione della variabile");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        assertTrue("Il vettore di interi deve essere inizializzato come List<int>", code.contains(var + "=new System.Collections.Generic.List<int>();"));
        assertFalse("Il codice C# non deve contenere tipi Java" , code.contains("java.util") || code.contains("Integer"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper Java, JString, true.
    * Oracolo: codice generato, dichiarazione presente, vettore di stringhe inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadOfStringWithDecl_TC09() {
        JVector vector = new JVector(new JString());
        String code = vector.genJavaReadWrapper("values", "items", true);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "java\\.util\\.List\\s+([a-zA-Z_]\\w*)\\s*;";
        Matcher matcher = findMatch(code, string, "Con decl=true deve essere presente la dichiarazione della variabile");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        assertTrue("Il vettore di stringhe deve essere inizializzato come ArrayList<String>" , code.contains(var + "=new java.util.ArrayList<String>();"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper C#, JString, true.
    * Oracolo: codice generato, dichiarazione presente, vettore di stringhe inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadOfStringWithDecl_TC10() {
        JVector vector = new JVector(new JString());
        String code = vector.genCsharpReadWrapper("values", "items", true);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "System\\.Collections\\.Generic\\.List<string>\\s+([a-zA-Z_]\\w*)\\s*;";
        Matcher matcher = findMatch(code, string, "Con decl=true deve essere presente la dichiarazione della variabile");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        assertTrue("Il vettore di stringhe deve essere inizializzato come List<string>", code.contains(var + "=new System.Collections.Generic.List<string>();"));
        assertFalse("Il codice C# non deve contenere tipi Java" , code.contains("java.util"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper Java, JVector(JString), true.
    * Oracolo: codice generato, dichiarazione presente, vettore di vettori di stringhe inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadOfVectorWithDecl_TC11() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genJavaReadWrapper("values", "items", true);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String outerString = "java\\.util\\.List\\s+([a-zA-Z_]\\w*)\\s*;";
        Matcher matcher = findMatch(code, outerString, "Con decl=true deve essere presente la dichiarazione della variabile");
        // si estrae il nome della variabile
        String outerVar = matcher.group(1);
        assertTrue("Il vettore esterno deve essere inizializzato come lista di liste di stringhe", code.contains(outerVar + "=new java.util.ArrayList<java.util.List<String>>();"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper C#, JVector(JString), true.
    * Oracolo: codice generato, dichiarazione presente, vettore di vettori di stringhe inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadOfVectorWithDecl_TC12() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genCsharpReadWrapper("values", "items", true);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String outerString = "System\\.Collections\\.Generic\\.List<System\\.Collections\\.Generic\\.List<string>>\\s+([a-zA-Z_]\\w*)\\s*;";
        Matcher matcher = findMatch(code, outerString, "Con decl=true deve essere presente la dichiarazione della variabile");
        // si estrae il nome della variabile
        String outerVar = matcher.group(1);
        assertTrue("Il vettore esterno deve essere inizializzato come lista di liste di stringhe", code.contains(outerVar + "=new System.Collections.Generic.List<System.Collections.Generic.List<string>>();"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper Java, JInt, false.
    * Oracolo: codice generato, dichiarazione assente, vettore di interi inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadOfIntWithoutDecl_TC13() {
        JVector vector = new JVector(new JInt());
        String code = vector.genJavaReadWrapper("values", "items", false);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        /*
            - [^>]+ : serve perche' il tipo dell'elemento interno all'array potrebbe non essere corretto (^> serve per fermarsi a >)
        */
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+java\\.util\\.ArrayList<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        String elemType = matcher.group(2);
        // con decl = false, non deve comparire la dichiarazione della variabile
        assertFalse("Con decl=false non deve essere dichiarata la variabile del vettore", code.contains("java.util.List " + var + ";") || code.contains("java.util.List<Integer> " + var + ";"));
        assertEquals("Il vettore di interi deve essere inizializzato come ArrayList<Integer>" , "Integer", elemType);
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper C#, JInt, false.
    * Oracolo: codice generato, dichiarazione assente, vettore di interi inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadOfIntWithoutDecl_TC14() {
        JVector vector = new JVector(new JInt());
        String code = vector.genCsharpReadWrapper("values", "items", false);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+System\\.Collections\\.Generic\\.List<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        String elemType = matcher.group(2);
        // con decl = false, non deve comparire la dichiarazione della variabile
        assertFalse("Con decl=false non deve essere dichiarata la variabile del vettore", code.contains("System.Collections.Generic.List<int> "+var+";"));
        assertEquals("Il vettore di interi deve essere inizializzato come List<int>", "int", elemType);
        assertFalse("Il codice C# non deve contenere tipi Java" , code.contains("java.util") || code.contains("Integer"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper Java, JString, false.
    * Oracolo: codice generato, dichiarazione assente, vettore di stringhe inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadOfStringWithoutDecl_TC15() {
        JVector vector = new JVector(new JString());
        String code = vector.genJavaReadWrapper("values", "items", false);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+java\\.util\\.ArrayList<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        String elemType = matcher.group(2);
        // con decl = false, non deve comparire la dichiarazione della variabile
        assertFalse("Con decl=false non deve essere dichiarata la variabile del vettore", code.contains("java.util.List " + var + ";") || code.contains("java.util.List<String> " + var + ";"));
        assertEquals("Il vettore di stringhe deve essere inizializzato come ArrayList<String>", "String", elemType);
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper C#, JString, false.
    * Oracolo: codice generato, dichiarazione assente, vettore di stringhe inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadOfStringWithoutDecl_TC16() {
        JVector vector = new JVector(new JString());
        String code = vector.genCsharpReadWrapper("values", "items", false);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+System\\.Collections\\.Generic\\.List<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        // si estrae il nome della variabile
        String var = matcher.group(1);
        String elemType = matcher.group(2);
        // con decl = false, non deve comparire la dichiarazione della variabile
        assertFalse("Con decl=false non deve essere dichiarata la variabile del vettore", code.contains("System.Collections.Generic.List<string> "+var+";"));
        assertEquals("Il vettore di stringhe deve essere inizializzato come List<string>", "string", elemType);
        assertFalse("Il codice C# non deve contenere tipi Java" , code.contains("java.util"));
    }


    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper Java, JVector(JString), false.
    * Oracolo: codice generato, dichiarazione assente, vettore di vettori di stringhe inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadOfVectorWithoutDecl_TC17() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genJavaReadWrapper("values", "items", false);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String outerString = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+java\\.util\\.ArrayList<java\\.util\\.List<String>>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, outerString, "Deve essere presente l'inizializzazione del vettore esterno");
        // si estrae il nome del vettore esterno
        String outerVar = matcher.group(1);
        // con decl = false, non deve comparire la dichiarazione della variabile
        assertFalse("Con decl=false non deve essere dichiarata la variabile del vettore", code.contains("java.util.List " + outerVar + ";") || code.contains("java.util.List<java.util.List<String>> " + outerVar + ";"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto, dichiarazione.
    * Classi di equivalenza: wrapper C#, JVector(JString), false.
    * Oracolo: codice generato, dichiarazione assente, vettore di vettori di stringhe inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadOfVectorWithoutDecl_TC18() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genCsharpReadWrapper("values", "items", false);
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String outerString = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+System\\.Collections\\.Generic\\.List<System\\.Collections\\.Generic\\.List<string>>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, outerString, "Deve essere presente l'inizializzazione del vettore esterno");
        // si estrae il nome del vettore esterno
        String outerVar = matcher.group(1);
        // con decl = false, non deve comparire la dichiarazione della variabile
        assertFalse("Con decl=false non deve essere dichiarata la variabile del vettore", code.contains("System.Collections.Generic.List<System.Collections.Generic.List<string>> " + outerVar + ";"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo Java, JInt.
    * Oracolo: codice generato, vettore di interi inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadMethodOfInt_TC19() {
        JVector vector = new JVector(new JInt());
        String code = vector.genJavaReadMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+java\\.util\\.ArrayList<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        String elemType = matcher.group(2);
        assertEquals("Il vettore di interi deve essere inizializzato come ArrayList<Integer>" , "Integer", elemType);
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo Java, JString.
    * Oracolo: codice generato, vettore di stringhe inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadMethodOfString_TC20() {
        JVector vector = new JVector(new JString());
        String code = vector.genJavaReadMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+java\\.util\\.ArrayList<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        String elemType = matcher.group(2);
        assertEquals("Il vettore di stringhe deve essere inizializzato come ArrayList<String>", "String", elemType);
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo Java, JVector(JString).
    * Oracolo: codice generato, vettore di vettori di stringhe inizializzato correttamente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaReadMethodOfVector_TC21() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genJavaReadMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String outerString = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+java\\.util\\.ArrayList<java\\.util\\.List<String>>\\s*\\(\\s*\\)\\s*;";
        findMatch(code, outerString, "Deve essere presente l'inizializzazione del vettore esterno");
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo C#, JInt.
    * Oracolo: codice generato, vettore di interi inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadMethodOfInt_TC22() {
        JVector vector = new JVector(new JInt());
        String code = vector.genCsharpReadMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+System\\.Collections\\.Generic\\.List<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        String elemType = matcher.group(2);
        assertEquals("Il vettore di interi deve essere inizializzato come List<int>", "int", elemType);
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo C#, JString.
    * Oracolo: codice generato, vettore di stringhe inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadMethodOfString_TC23() {
        JVector vector = new JVector(new JString());
        String code = vector.genCsharpReadMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String string = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+System\\.Collections\\.Generic\\.List<([^>]+)>\\s*\\(\\s*\\)\\s*;";
        Matcher matcher = findMatch(code, string, "Deve essere presente l'inizializzazione del vettore");
        // si estrae il nome della variabile
        String elemType = matcher.group(2);
        assertEquals("Il vettore di stringhe deve essere inizializzato come List<string>", "string", elemType);
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della lettura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo C#, JVector(JString).
    * Oracolo: codice generato, vettore di vettori di stringhe inizializzato correttamente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpReadMethodOfVector_TC24() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genCsharpReadMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        String outerString = "([a-zA-Z_]\\w*)\\s*=\\s*new\\s+System\\.Collections\\.Generic\\.List<System\\.Collections\\.Generic\\.List<string>>\\s*\\(\\s*\\)\\s*;";
        findMatch(code, outerString, "Deve essere presente l'inizializzazione del vettore esterno");
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: wrapper Java, JInt.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaWriteOfInt_TC25() {
        JVector vector = new JVector(new JInt());
        String code = vector.genJavaWriteWrapper("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new java.util.ArrayList"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: wrapper C#, JInt.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateCsharpWriteOfInt_TC26() {
        JVector vector = new JVector(new JInt());
        String code = vector.genCsharpWriteWrapper("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new System.Collections.Generic.List"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util") || code.contains("Integer"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: wrapper Java, JString.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaWriteOfString_TC27() {
        JVector vector = new JVector(new JString());
        String code = vector.genJavaWriteWrapper("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new java.util.ArrayList"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: wrapper C#, JString.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateCsharpWriteOfString_TC28() {
        JVector vector = new JVector(new JString());
        String code = vector.genCsharpWriteWrapper("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new System.Collections.Generic.List"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: wrapper Java, JVector(JString).
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaWriteOfVector_TC29() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genJavaWriteWrapper("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new java.util.ArrayList"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: wrapper C#, JVector(JString).
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateCsharpWriteOfVector_TC30() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genCsharpWriteWrapper("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new System.Collections.Generic.List"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo Java, JInt.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaWriteMethodOfInt_TC31() {
        JVector vector = new JVector(new JInt());
        String code = vector.genJavaWriteMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new java.util.ArrayList"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo Java, JString.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaWriteMethodOfString_TC32() {
        JVector vector = new JVector(new JString());
        String code = vector.genJavaWriteMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new java.util.ArrayList"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo Java, JVector(JString).
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni C#.
    */
    @Test
    public void generateJavaWriteMethodOfVector_TC33() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genJavaWriteMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new java.util.ArrayList"));
        assertFalse("Il codice Java non deve contenere tipi C#", code.contains("System.Collections.Generic"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo C#, JInt.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpWriteMethodOfInt_TC34() {
        JVector vector = new JVector(new JInt());
        String code = vector.genCsharpWriteMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new System.Collections.Generic.List"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo C#, JString.
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpWriteMethodOfString_TC35() {
        JVector vector = new JVector(new JString());
        String code = vector.genCsharpWriteMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new System.Collections.Generic.List"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

    /*
    * Unita': generazione della scrittura di un vettore.
    * Categorie: punto di ingresso, elemento scelto.
    * Classi di equivalenza: metodo C#, JVector(JString).
    * Oracolo: codice generato, inizializzazione del vettore non presente, assenza dichiarazioni Java.
    */
    @Test
    public void generateCsharpWriteMethodOfVector_TC36() {
        JVector innerVector = new JVector(new JString());
        JVector outerVector = new JVector(innerVector);
        String code = outerVector.genCsharpWriteMethod("values", "items");
        assertFalse("Il codice generato non deve essere vuoto", code.trim().isEmpty());
        // si verifica che non venga inizializzato un nuovo vettore perche' l'operazione deve serializzare un vettore gia' esistente
        assertFalse("La scrittura non deve inizializzare un nuovo vettore", code.contains("new System.Collections.Generic.List"));
        assertFalse("Il codice C# non deve contenere tipi Java", code.contains("java.util"));
    }

}