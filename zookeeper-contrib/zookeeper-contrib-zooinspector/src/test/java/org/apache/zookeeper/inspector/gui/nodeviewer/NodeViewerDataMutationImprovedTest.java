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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NodeViewerDataMutationImprovedTest {

    private IconResource prevIconResource;

    @Before
    public void setIcon() {
        // si salva il valore dell'icon resource
        this.prevIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
    }

    /*
     * Unita': costruzione del viewer.
     * Oracolo: il viewer deve avere il layout e i componenti interni necessari a visualizzare e salvare i dati.
    */
    @Test
    public void buildDetailedNodeViewerData_TCM01() {
        NodeViewerData viewer = new NodeViewerData();
        // si verifica che il layout sia un'istanza di BorderLayout (dal mutante 1)
        assertTrue("Il viewer deve usare BorderLayout", viewer.getLayout() instanceof BorderLayout);

        JToolBar toolBar = null;
        JScrollPane scrollPane = null;
        for(Component component : viewer.getComponents()) {
            if (component instanceof JToolBar) {
                toolBar =(JToolBar) component;
            } else if (component instanceof JScrollPane) {
                scrollPane = (JScrollPane) component;
            }

        }
        assertTrue("Il viewer deve contenere la toolbar", toolBar != null);
        // si verifica che la toolbar non sia floatable (dal mutante 2)
        assertFalse("La toolbar non deve essere floatable", toolBar.isFloatable());

        // si verifica che lo scrollpane esista, ossia che sia stato aggiunto al layout (dal mutante 4)
        assertTrue("Il viewer deve contenere la toolbar", scrollPane != null);
        // si verifica che lo scroll pane abbia impostazione HORIZONTAL_SCROLLBAR_NEVER (dal mutante 3)
        assertTrue("La toolbar non deve essere scrollabile orizzontalmente", scrollPane.getHorizontalScrollBarPolicy() == JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   }

    /*
     * Unita': visualizzazione del contenuto nel viewer.
     * Oracolo: il viewer deve mostrare il contenuto restituito al manager.
    */
    @Test
    public void verifyContent_TCM02() throws InterruptedException {
        // si crea mock di ZooInspectorNodeManager
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        // si crea stub del risultato di getData
        when(manager.getData("/node")).thenReturn("contenuto");
        NodeViewerData viewer = new NodeViewerData();
        viewer.setZooInspectorManager(manager);
        // si crea lista dei nodi selezionati (se ne aggiunge solo uno)
        List<String> selectedNodes = new ArrayList<>();
        selectedNodes.add("/node");
        // si comunica al viewer che e' cambiata la selezione dei nodi e ora deve mostrare solo node
        viewer.nodeSelectionChanged(selectedNodes);
        // si verifica con Mockito che sul mock sia stata effettuata la chiamata a getData("node")
        // il timeout e' necessario perche' il caricamento avviene in modo asincrono
        verify(manager, timeout(1000)).getData("/node");

        JTextPane dataPane = null;
        for(Component component : viewer.getComponents()) {
            if (component instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) component;
                dataPane = (JTextPane) scrollPane.getViewport().getView();
            }
        }
        assertTrue("Il viewer deve contenere l'area per i dati", dataPane != null);
        int i = 0;
        while (!"contenuto".equals(dataPane.getText()) && i < 100) {
            Thread.sleep(10);
            i++;
        }
        assertTrue("Il viewer deve mostrare il contenuto fornito al manager", dataPane.getText().equals("contenuto"));
   }

    @After
    public void restoreIcon() {
        ZooInspector.iconResource = this.prevIconResource;
    }
}