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

package org.apache.zookeeper.inspector.gui.nodeviewer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;

public class NodeViewerDataBlackBoxTest {

    private IconResource prevIconResource;

    @Before
    public void setIcon() {
        // si salva il valore dell'icon resource
        this.prevIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
    }

    /*
    * Unita': costruzione del viewer.
    * Oracolo: deve essere restituita un'istanza non nulla.
    */
    @Test
    public void buildNodeViewerData_TC01() {
        NodeViewerData viewer = new NodeViewerData();
        assertNotNull("Il viewer del nodo deve essere creato", viewer);
    }

    /*
    * Unita': restituzione del titolo.
    * Oracolo: il titolo deve essere non nullo e non vuoto.
    */
    @Test
    public void getTitle_TC02() {
        NodeViewerData viewer = new NodeViewerData();
        String title = viewer.getTitle();
        assertNotNull("Il titolo non deve essere null", title);
        assertFalse("Il titolo non deve essere vuoto", title.trim().isEmpty());
    }

    /*
    * Unita': reazione alla selezione dei nodi.
    * Classe di equivalenza: lista contenente un nodo.
    * Oracolo: il manager deve ricevere una richiesta per il nodo selezionato.
    */
    @Test
    public void selectOneNode_TC03() {
        // si crea mock di ZooInspectorNodeManager
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        // si crea stub del risultato di getData
        when(manager.getData("/node")).thenReturn("contenuto");
        // si crea viewer
        NodeViewerData viewer = new NodeViewerData();
        // si fornisce manager
        viewer.setZooInspectorManager(manager);
        // si crea lista dei nodi selezionati (se ne aggiunge solo uno)
        List<String> selectedNodes = new ArrayList<>();
        selectedNodes.add("/node");
        // si comunica al viewer che e' cambiata la selezione dei nodi e ora deve mostrare solo node
        viewer.nodeSelectionChanged(selectedNodes);
        // si verifica con Mockito che sul mock sia stata effettuata la chiamata a getData("node")
        // il timeout e' necessario perche' il caricamento avviene in modo asincrono
        verify(manager, timeout(1000)).getData("/node");
    }

    /*
    * Unita': reazione alla selezione dei nodi.
    * Classe di equivalenza: lista vuota.
    * Oracolo: il manager non deve ricevere richieste di lettura.
    */
    @Test
    public void selectNoNode_TC04() {
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        NodeViewerData viewer = new NodeViewerData();
        viewer.setZooInspectorManager(manager);
        List<String> selectedNodes = new ArrayList<>();
        viewer.nodeSelectionChanged(selectedNodes);
        verify(manager, never()).getData(anyString());
    }

    @After
    public void restoreIcon() {
        ZooInspector.iconResource = this.prevIconResource;
    }
}