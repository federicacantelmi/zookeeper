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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class JVectorMutationImprovedTest {

    /*
     * Unita': verifica della generazione del nome C di un vettore di elementi.
     * Oracolo: il nome deve essere la stringa "Int_vector".
     */
    @Test
    public void extractIntVectorName_TCM01() {
        String vectorName = JVector.extractVectorName(new JInt());
        assertTrue("Il nome C del vettore di interi non e' corretto", vectorName.equals("Int_vector"));
    }

    /*
    * Funzione ausiliaria che estrae dal codice gli identificatori generati per gli indici dei vettori
    * e verifica che siano validi e diversi livello per livello.
    */
    private void assertValidAndDifferentVectorNames(String code) {
        // il segno - serve perche' bisogna poter estrarre anche nomi non validi come "vidx-1"
        Pattern pattern = Pattern.compile("vidx-?\\d*");
        Matcher matcher = pattern.matcher(code);
        Set<String> indexes = new HashSet<>();
        // si inseriscono i nomi delle variabili nell'hash set, quindi se due sono uguali allora ne verrà inserito solo uno
        while (matcher.find()) {
            String name = matcher.group();
            // si verifica che il nome estratto sia della forma: lettere + cifre
            assertTrue("L'identificatore generato non e' valido: " + name, name.matches("[a-zA-Z_$][a-zA-Z0-9_$]*"));
            indexes.add(name);
        }
        // se non ci sono almeno due elementi nell'hash set, significa che livelli successivi utilizzano stessi nomi delle variabilik
        assertTrue("I nomi delle variabili nei dievrsi livelli devono essere diversi", indexes.size() >= 2);
    }

    /*
    * Unita': generazione del wrapper read Java di un vettore annidato.
    * Oracolo:
    * - due generazioni con gli stessi input devono produrre lo stesso codice;
    * - gli indici dei diversi livelli devono essere validi e distinti.
    */
    @Test
    public void generateRepeatableJavaReadWrapper_TCM02() {
        JVector innerVector = new JVector(new JInt());
        JVector outerVector = new JVector(innerVector);
        String firstCode = outerVector.genJavaReadWrapper("values", "items", false);
        String secondCode = outerVector.genJavaReadWrapper("values", "items", false);
        assertEquals("Due generazioni Java di lettura con gli stessi input devono produrre lo stesso codice", firstCode, secondCode);
        assertValidAndDifferentVectorNames(firstCode);
    }

    /*
    * Unita': generazione del wrapper write Java di un vettore annidato.
    * Oracolo:
    * - due generazioni con gli stessi input devono produrre lo stesso codice;
    * - gli indici dei diversi livelli devono essere validi e distinti.
    */
    @Test
    public void generateRepeatableJavaWriteWrapper_TCM03() {
        JVector innerVector = new JVector(new JInt());
        JVector outerVector = new JVector(innerVector);
        String firstCode = outerVector.genJavaWriteWrapper("values", "items");
        String secondCode = outerVector.genJavaWriteWrapper("values", "items");
        assertEquals("Due generazioni Java di scrittura con gli stessi input devono produrre lo stesso codice", firstCode, secondCode);
        assertValidAndDifferentVectorNames(firstCode);
    }

    /*
    * Unita': generazione del wrapper read C# di un vettore annidato.
    * Oracolo:
    * - due generazioni con gli stessi input devono produrre lo stesso codice;
    * - gli indici dei diversi livelli devono essere validi e distinti.
    */
    @Test
    public void generateRepeatableCsharpReadWrapper_TCM04() {
        JVector innerVector = new JVector(new JInt());
        JVector outerVector = new JVector(innerVector);
        String firstCode = outerVector.genCsharpReadWrapper("values", "items", false);
        String secondCode = outerVector.genCsharpReadWrapper("values", "items", false);
        assertEquals("Due generazioni C# di lettura con gli stessi input devono produrre lo stesso codice", firstCode, secondCode);
        assertValidAndDifferentVectorNames(firstCode);
    }

    /*
    * Unita': generazione del wrapper write C# di un vettore annidato.
    * Oracolo:
    * - due generazioni con gli stessi input devono produrre lo stesso codice;
    * - gli indici dei diversi livelli devono essere validi e distinti.
    */
    @Test
    public void generateRepeatableCsharpWriteWrapper_TCM05() {
        JVector innerVector = new JVector(new JInt());
        JVector outerVector = new JVector(innerVector);
        String firstCode = outerVector.genCsharpWriteWrapper("values", "items");
        String secondCode = outerVector.genCsharpWriteWrapper("values", "items");
        assertEquals("Due generazioni C# di scrittura con gli stessi input devono produrre lo stesso codice", firstCode, secondCode);
        assertValidAndDifferentVectorNames(firstCode);
    }



}
