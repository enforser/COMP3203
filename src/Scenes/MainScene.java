// ======================================================================================
// FILE: MainScene.java
// CREATION DATE: NOV 06, 2016
// ABOUT: Sets up the main scene
// ======================================================================================

package Scenes;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import main.Graphing;

public class MainScene {
	
	//Properties -------------------------------------------------------------
	Scene mainScene;
	
	VBox mainPane;
	
	//Input Pane
	HBox inputPane;
	TextField num_SensorInput;
	TextField radius_SensorInput;
	ComboBox<String> algorithmInput;
	Button simulateButton;
	
	//Interval Pane
	HBox intervalPane;
	Separator interval; //this is temporary until we find something better
	
	//Graphing Pane
	HBox graphPane;
	Graphing graph;
	
	//Constructor -------------------------------------------------------------
	public MainScene(){
		createMainElements();
		createMainScene();
	}
	
	//Methods -----------------------------------------------------------------
	public Scene getMainScene() {
		return mainScene;		
	}
	
	public Graphing getGraphing(){
		return graph;
	}

	private void createMainElements(){
		//Input Pane
		num_SensorInput = new TextField();
		num_SensorInput.setPromptText("Number of Sensors");
		
		radius_SensorInput = new TextField();
		radius_SensorInput.setPromptText("Radius of Sensors");
		
		algorithmInput = new ComboBox<String>();
		algorithmInput.getItems().addAll("Rigid Algorithm","Simple Algortithm");
		algorithmInput.getSelectionModel().selectFirst();
		
		simulateButton = new Button("Simulate");
		
		//Interval Pane
		interval = new Separator();

		
		//Graph Pane
		graph = new Graphing();
		
	}
	
	private void createMainScene(){
		mainPane = new VBox();
		
		//Input Pane
		inputPane = new HBox(10);
		inputPane.setPadding(new Insets(10, 10, 10, 10));
		inputPane.getChildren().addAll(num_SensorInput,radius_SensorInput,algorithmInput,simulateButton);
		
		//Interval Pane
		intervalPane = new HBox();
		intervalPane.getChildren().add(interval);
		
		//Graph Pane
		graphPane = new HBox();
		graphPane.setPadding(new Insets(10, 10, 10, 10));
		graphPane.getChildren().addAll(graph.getGraphing());
		
		mainPane.getChildren().addAll(inputPane,intervalPane,graphPane);
		
		mainScene = new Scene(mainPane);
	}
}
