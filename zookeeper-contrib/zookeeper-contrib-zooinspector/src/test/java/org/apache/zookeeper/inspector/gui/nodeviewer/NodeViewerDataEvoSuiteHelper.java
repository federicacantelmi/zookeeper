/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0.
 */

package org.apache.zookeeper.inspector.gui.nodeviewer;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.inspector.ZooInspector;
import org.apache.zookeeper.inspector.gui.IconResource;

public class NodeViewerDataEvoSuiteHelper {

    // Metodo che inizializza l'icon, altrimenti il costruttore fallisce
    public NodeViewerData createViewer() {
        ZooInspector.iconResource = new IconResource();
        return new NodeViewerData();
    }

    // Metodo che simula la selezione di un nodo con lista vuota
    public void selectNoNode(NodeViewerData viewer) {
        viewer.nodeSelectionChanged(new ArrayList<String>());
    }

    public String getTitle(NodeViewerData viewer) {
        return viewer.getTitle();
    }

    // Metodo che crea una lista vuota di selezione
    public List<String> createEmptySelection() {
        return new ArrayList<String>();
    }
}