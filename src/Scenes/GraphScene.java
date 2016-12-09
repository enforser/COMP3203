// ======================================================================================
// FILE: MainScene.java
// CREATION DATE: NOV 06, 2016
// ABOUT: Sets up the main scene
// ======================================================================================

package Scenes;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

import main.Graphing;

public class GraphScene {
	
	//Properties -------------------------------------------------------------
	Scene graphScene;
	
	//Graphing Pane
	HBox graphPane;
	Graphing graph;
	
	//Constructor -------------------------------------------------------------
	public GraphScene(){
		createMainElements();
		createMainScene();
	}
	
	//Methods -----------------------------------------------------------------
	public Scene getGraphScene() {
		return graphScene;		
	}
	
	public Graphing getGraph(){
		return graph;
	}

	private void createMainElements(){	
		//Graph Pane
		graph = new Graphing();
		graphPane = new HBox();
	}
	
	private void createMainScene(){
		//Graph Pane
		graphPane.setPadding(new Insets(10, 10, 10, 10));
		graphPane.getChildren().addAll(graph.getLChart());
		
		graphScene = new Scene(graphPane);
	}
}
