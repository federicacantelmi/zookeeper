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

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

public class NodeViewerDataManualImprovedTest {

    private IconResource prevIconResource;

    @Before
    public void setIcon() {
        // si salva il valore dell'icon resource
        this.prevIconResource = ZooInspector.iconResource;
        ZooInspector.iconResource = new IconResource();
    }

    /* Metodo ausiliario per trovare button nel viewer */
    private JButton findSaveButton(NodeViewerData viewer) {
        for (Component component : viewer.getComponents()) {
            if (component instanceof JToolBar) {
                JToolBar toolbar = (JToolBar) component;
                for (Component toolbarComponent : toolbar.getComponents()) {
                    if (toolbarComponent instanceof JButton) {
                        return (JButton) toolbarComponent;
                    }
                }
            }
        }
        return null;
    }

    /*
    * Unita': salvataggio di un nodo.
    * Classe di equivalenza: lista di nodi vuota, conferma non attesa.
    * Oracolo: il manager non deve ricevere alcuna richiesta di aggiornamento.
    */
    @Test
    public void saveWithoutSelectedNode_TCI01() {
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        NodeViewerData viewer = new NodeViewerData();
        // si fornisce al viewer il mock usato come punto di osservazione
        viewer.setZooInspectorManager(manager);
        // viene passato al metodo una lista vuota
        List<String> selectedNodes = new ArrayList<>();
        viewer.nodeSelectionChanged(selectedNodes);
        // si invoca metodo per ottenere il save button del viewer
        JButton saveButton = findSaveButton(viewer);
        assertNotNull("Il viewer deve esporre il button per il salvataggio", saveButton);
        // si simula il press del save button, il quale permette di attivare i listener ed eseguire il metodo actionPerformed
        saveButton.doClick(0);
        verify(manager, never()).setData(any(), any());
    }

    /* Metodo ausiliario necessario poiche' la classe invoca JOptionPane.showConfirmDialog(...) per verificare se utente ha confermato o negato
     * la modifica, solo che JOptionPane.showConfirmDialog(...) e' un metodo statico */
    private void simulateAnswerSaveButton(JButton saveButton, int answer) {
        // siccome il mock va assolutamente chiuso al termine dell'operazione, viene racchiuso in un blocco try-with-resources
        try (MockedStatic<JOptionPane> optionPane = mockStatic(JOptionPane.class)) {
            // quando viene invocato JOptionPane.showConfirmDialog(...) dal metodo actionPerformed() che viene invocato quando si verifica un evento
            // di salvataggio del nodo selezionato, allora l'option pane mockato deve restituire l'opzione fornita in input (answer)
            optionPane.when(() -> JOptionPane.showConfirmDialog(any(), anyString(), anyString(), anyInt(), anyInt())).thenReturn(answer);
            // si simula il press del save button
            saveButton.doClick(0);
            // si verifica che la richiesta di conferma sia stata mostrata
            optionPane.verify(() -> JOptionPane.showConfirmDialog(any(), anyString(), anyString(), anyInt(), anyInt()));
        }
    }

    /*
    * Unita': salvataggio di un nodo.
    * Classe di equivalenza: lista con un nodo, conferma rifiutata.
    * Oracolo: deve essere richiesta la conferma, ma il manager non deve ricevere alcuna richiesta di aggiornamento.
    */
    @Test
    public void cancelSaveOfSelectedNode_TCI02() {
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        // si crea stub del risultato di getData
        // il contenuto e' irrilevante perche' l'utente rifiuta il salvataggio
        when(manager.getData("/node")).thenReturn("contenuto trascurato");
        NodeViewerData viewer = new NodeViewerData();
        // si fornisce al viewer il mock usato come punto di osservazione
        viewer.setZooInspectorManager(manager);
        // viene passato al metodo una lista con un nodo
        List<String> selectedNodes = new ArrayList<>();
        selectedNodes.add("/node");
        viewer.nodeSelectionChanged(selectedNodes);
        // si invoca metodo per ottenere il save button del viewer
        JButton saveButton = findSaveButton(viewer);
        assertNotNull("Il viewer deve esporre il button per il salvataggio", saveButton);
        // si passa NO_OPTION che corrisponde al rifiuto della conferma
        simulateAnswerSaveButton(saveButton, JOptionPane.NO_OPTION);
        // si verifica che il manager non abbia ricevuto alcuna richiesta di aggiornamento
        verify(manager, never()).setData(any(), any());
    }

    /*
    * Unita': salvataggio di un nodo.
    * Classe di equivalenza: lista con un nodo, conferma concessa.
    * Oracolo: il manager deve ricevere una richiesta di aggiornamento relativa al nodo selezionato e contenente la stringa vuota.
    */
    @Test
    public void saveEmptyContentOfSelectedNode_TCI03() {
        ZooInspectorNodeManager manager = mock(ZooInspectorNodeManager.class);
        // si crea stub del risultato di getData
        when(manager.getData("/node")).thenReturn("");
        NodeViewerData viewer = new NodeViewerData();
        // si fornisce al viewer il mock usato come punto di osservazione
        viewer.setZooInspectorManager(manager);
        // viene passato al metodo una lista con un nodo
        List<String> selectedNodes = new ArrayList<>();
        selectedNodes.add("/node");
        viewer.nodeSelectionChanged(selectedNodes);
        // si invoca metodo per ottenere il save button del viewer
        JButton saveButton = findSaveButton(viewer);
        assertNotNull("Il viewer deve esporre il button per il salvataggio", saveButton);
        // si passa YES_OPTION che corrisponde al concedimento della conferma
        simulateAnswerSaveButton(saveButton, JOptionPane.YES_OPTION);
        // si verifica che il manager abbia ricevuto la richiesta di aggiornamento con contenuto vuoto
        verify(manager).setData("/node", "");
    }

    @After
    public void restoreIcon() {
        ZooInspector.iconResource = this.prevIconResource;
    }
}