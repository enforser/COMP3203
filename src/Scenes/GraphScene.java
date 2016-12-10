// ======================================================================================
// FILE: MainScene.java
// CREATION DATE: NOV 06, 2016
// ABOUT: Sets up the main scene
// ======================================================================================

package Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Graphing;

public class GraphScene {
	
	//Properties -------------------------------------------------------------
	private Scene graphScene;
	
	private final int SCENE_WIDTH = 600;
	private final int SCENE_HEIGHT = 500;
	
	private Scene returnScene;
	private Stage window;
	
	//Graphing Pane
	private VBox graphPane;
	private Graphing graph;
	private Button homeButton;
	private Separator line;
	
	//Constructor -------------------------------------------------------------
	public GraphScene(){
		createMainElements();
		createMainScene();
	}
	
	public GraphScene(Scene rs, Stage w){
		returnScene = rs;
		window = w;
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
		line = new Separator();
		graph = new Graphing();
		graphPane = new VBox();
		homeButton = new Button("Return");
	}
	
	private void createMainScene(){
		//Graph Pane
		
		homeButton.setOnAction(e -> {
			if(window != null && returnScene != null){
				System.out.println("-- return button was clicked");
				window.setScene(returnScene);
			}
		});
		
		graphPane.setSpacing(5);
		graphPane.setAlignment(Pos.CENTER);
		graphPane.setPadding(new Insets(10, 10, 10, 10));
		graphPane.getChildren().addAll(graph.getLChart(),line,homeButton);
		
		graphScene = new Scene(graphPane,SCENE_WIDTH, SCENE_HEIGHT);
	}
}
