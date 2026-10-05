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

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;
import org.apache.zookeeper.inspector.manager.ZooInspectorNodeManager;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NodeViewerDataRandoopHelper {

    private NodeViewerDataRandoopHelper() {}

    /*
     * Restituisce un viewer con le dipendenze normalmente
     * predisposte dall'applicazione.
     */
    public static NodeViewerData createViewer() {
        ZooInspector.iconResource = new IconResource();

        ZooInspectorNodeManager manager =
                mock(ZooInspectorNodeManager.class);
        when(manager.getData(anyString())).thenReturn("contenuto");

        NodeViewerData viewer = new NodeViewerData();
        viewer.setZooInspectorManager(manager);

        return viewer;
    }

    /*
     * Fornisce un rappresentante della classe di input
     * corrispondente a nessun nodo selezionato.
     */
    public static List<String> createEmptySelection() {
        return new ArrayList<>();
    }

    /*
     * Fornisce un rappresentante della classe di input
     * corrispondente a un nodo selezionato.
     */
    public static List<String> createSingleSelection() {
        List<String> selectedNodes = new ArrayList<>();
        selectedNodes.add("/node");
        return selectedNodes;
    }

}