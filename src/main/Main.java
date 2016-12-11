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
		 * The following is a demonstration to view the output of the algorithms in the console. 
		 * 
		 * It covers Rigid, Simple, Overlap, and Split. 
		 */
		
		
			RigidAlgorithm algoR;
			SimpleAlgorithm algoS;
			OverlapAlgorithm algoO;
			SplitAlgorithm algoSP;
			int runTimes = 300;
			double[] movement = {0, 0, 0, 0};
			int numSensors = 5;
			double radius = 0.1;
			
			for (int i = 0; i < runTimes; i++) {
				
				algoR = new RigidAlgorithm(numSensors, radius);
				algoS = new SimpleAlgorithm(numSensors, radius);
				algoO = new OverlapAlgorithm(numSensors, radius);
				algoSP = new SplitAlgorithm(numSensors, radius);
				
				movement[0] += algoR.run();
				movement[1] += algoS.run();
				movement[2] += algoO.run();
				movement[3] += algoSP.run();
			}

			//PRINT OUT RESULTS OF THE TEST
			System.out.println("\n\n\n\n   Run Times:           " + runTimes);
			System.out.println("   Number of Sensors:   " + numSensors);
			System.out.println("   Radius:              " + radius);
			System.out.println("   ----------------------------------------");
			System.out.println("   Rigid Algorithm:     " + movement[0]/runTimes);
			System.out.println("   Simple Algorithm:    " + movement[1]/runTimes);
			System.out.println("   Overlap Algorithm:   " + movement[2]/runTimes);
			System.out.println("   Split Algorithm:     " + movement[3]/runTimes);
	}
}


















