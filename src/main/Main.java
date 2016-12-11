// ======================================================================================
// FILE: Main.java
// CREATION DATE: OCT 19, 2016
// ABOUT: Starting point for the entire program
// ======================================================================================

package main;

import java.util.HashMap;

import Scenes.GraphScene;
import Scenes.SimulationScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	Button m_testButton;
	Button m_buttonTwo;
	Button m_buttonThree;
	
	Stage m_window;
	
	Scene m_scene1;
	Scene m_simulationScene;
	
	// ----------------------------------------------------------------------------------
	// Methods
	
	public static void main(String[] args) 
	{
		System.out.println("-- In main() method"); 
		System.out.println("-- calling launch()");
	
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		System.out.println("-- In start() method");
		
		m_window = primaryStage;
		m_window.setTitle("COMP3203 A2");
		
		createScene1();
		SimulationScene simulationScene = new SimulationScene();
		m_simulationScene = simulationScene.getSimulationScene();
		
		m_window.setScene(m_scene1);
		m_window.show();
	}

	// This method gets called whenever an event occurs
	@Override
	public void handle(ActionEvent event) 
	{
		if (event.getSource() == m_testButton)
		{
			System.out.println("-- buttonOne was clicked, in handle() method");
		}
	}
	
	public Stage getMainStage()
	{
		return m_window;
	}
	
	// ----------------------------------------------------------------------------------
	// Helper Functions
	
	private void createButtons()
	{
		m_testButton = new Button("Run Tests");
		m_testButton.setOnAction(e -> {
			System.out.println("-- Run Tests button was clicked");
			runTests();
		});
		
		m_buttonTwo = new Button("Simulation Scene");
		m_buttonTwo.setOnAction(e -> {
			System.out.println("-- buttonTwo was clicked");
			m_window.setScene(m_simulationScene);
		});
		 
		m_buttonThree = new Button("Button 3");
		m_buttonThree.setOnAction(e -> {
			System.out.println("-- buttonThree was clicked");
			//Button 3
			}
		);
	}
	
	private void createScene1()
	{
		Label titleLabel = new Label("Scene 1");
		
		createButtons();
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(titleLabel, m_testButton, m_buttonTwo, m_buttonThree);
		
		// Create the scene
		m_scene1 = new Scene(hbox, 600, 500);
	}
	
	private void runTests()
	{
		/*
		 * The following commented out code is an example of how to run the algorithm defined in the Algorithm class. 
		 * 
		 * */
			//Algorithm constructor takes number of sensors, and the radius of the sensors. 
		
		
			RigidAlgorithm algo;
			int runTimes = 200;
			double movement = 0;
			for (int i = 0; i < runTimes; i++) {
				algo = new RigidAlgorithm(20, 0.025);
				movement += algo.run();
			}
			System.out.println("Average movement of " + runTimes + " runs is: " + movement/runTimes);
	}
}


















