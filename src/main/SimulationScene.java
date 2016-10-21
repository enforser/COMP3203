// ======================================================================================
// FILE: SimulationScene.java
// CREATION DATE: OCT 19, 2016
// ABOUT: Potentially responsible for displaying the pictorial interface to illustrate 
//        sensor movement. 
// ======================================================================================

package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

public class SimulationScene 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private Scene m_simulationScene;
	
	private GridPane m_grid;
	
	private Label m_sensorInputLabel;
	private Label m_radiusInputLabel;
	
	private TextField m_numSensorInput;
	private TextField m_radiusInput;
	
	private Button m_simulateButton;
	
	private int m_numOfSensors;
	
	// ----------------------------------------------------------------------------------
	// Constructor 
	
	public SimulationScene()
	{
		createSimulationScene();
	}
	
	// ----------------------------------------------------------------------------------
	// Methods 
	
	public void createSimulationScene()
	{
		createSceneElements();
		createGridLayout();
		m_simulationScene = new Scene(m_grid, 500, 500);
	}
	
	public Scene getSimulationScene()
	{
		return m_simulationScene;
	}
	
	// ----------------------------------------------------------------------------------
	// Helper Functions
	
	private void createGridLayout()
	{
		m_grid = new GridPane();
		m_grid.setPadding(new Insets(10, 10, 10, 10));
		m_grid.setVgap(8);
		m_grid.setHgap(10);
		
		m_grid.getChildren().addAll(
				m_sensorInputLabel,
				m_radiusInputLabel,
				m_numSensorInput,
				m_radiusInput,
				m_simulateButton);
	}
	
	private void createSceneElements()
	{
		m_sensorInputLabel = new Label("Number of sensors:");
		GridPane.setConstraints(m_sensorInputLabel, 0, 0);
		
		m_numSensorInput = new TextField("2");
		GridPane.setConstraints(m_numSensorInput, 1, 0);
		
		m_radiusInputLabel = new Label("Radius:");
		GridPane.setConstraints(m_radiusInputLabel, 0, 1);
		
		m_radiusInput = new TextField("1");
		GridPane.setConstraints(m_radiusInput, 1, 1);
		
		m_simulateButton = new Button("Simulate");
		m_simulateButton.setTooltip(new Tooltip("Click to start simulation"));
		m_simulateButton.setOnMouseReleased(e -> {
			System.out.println("-- Simulate button was clicked");
			verifyUserInput();
			executeSimulation();
		});
		GridPane.setConstraints(m_simulateButton, 1, 2);
	}
	
	private void verifyUserInput()
	{
		InputVerifier verifier = new InputVerifier();
		verifier.isInt(m_numSensorInput, m_numSensorInput.getText());
		m_numOfSensors = Integer.parseInt(m_numSensorInput.getText());
	}
	
	private void executeSimulation()
	{
		Simulation simulation = new Simulation(m_numOfSensors);
	}
	
	
}













