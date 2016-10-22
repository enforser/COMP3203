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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	
	private Separator m_separator;
	
	private ToggleGroup m_toggleGroup;
	private RadioButton m_rigidRadio;
	private RadioButton m_simpleRadio;
	
	private Button m_simulateButton;
	
	private int m_numOfSensors;
	private String m_algorithmChoice;
	
	private final int SCENE_WIDTH = 600;
	private final int SCENE_HEIGHT = 500;
	
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
		m_simulationScene = new Scene(m_grid, SCENE_WIDTH, SCENE_HEIGHT);
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
				m_separator,
				m_rigidRadio,
				m_simpleRadio,
				m_simulateButton);
	}
	
	private void createSceneElements()
	{
		m_sensorInputLabel = new Label("Number of sensors:");
		GridPane.setConstraints(m_sensorInputLabel, 0, 0);
		
		m_numSensorInput = new TextField("2");
		GridPane.setConstraints(m_numSensorInput, 1, 0);
		
		m_radiusInputLabel = new Label("Radius:");
		GridPane.setConstraints(m_radiusInputLabel, 2, 0);
		
		m_radiusInput = new TextField("1");
		GridPane.setConstraints(m_radiusInput, 3, 0);
		
		m_separator = new Separator();
		m_separator.setMaxWidth(SCENE_WIDTH);
		GridPane.setConstraints(m_separator, 0, 2, 4, 1);
		
		m_toggleGroup = new ToggleGroup();
		
		m_rigidRadio = new RadioButton("Rigid Coverage");
		m_rigidRadio.setToggleGroup(m_toggleGroup);
		m_rigidRadio.setUserData(AlgorithmType.RIGID_COVERAGE);
		m_rigidRadio.setSelected(true);
		GridPane.setConstraints(m_rigidRadio, 0, 3, 2, 1);
		
		m_simpleRadio = new RadioButton("Simple Coverage");
		m_simpleRadio.setToggleGroup(m_toggleGroup);
		m_simpleRadio.setUserData(AlgorithmType.SIMPLE_COVERAGE);
		GridPane.setConstraints(m_simpleRadio, 2, 3, 2, 1);
		
		m_simulateButton = new Button("Simulate");
		m_simulateButton.setTooltip(new Tooltip("Click to start simulation"));
		m_simulateButton.setOnMouseReleased(e -> {
			System.out.println("-- Simulate button was clicked");
			verifyUserInput();
			executeSimulation();
		});
		GridPane.setConstraints(m_simulateButton, 0, 4);
	}
	
	private void verifyUserInput()
	{
		InputVerifier verifier = new InputVerifier();
		verifier.isInt(m_numSensorInput, m_numSensorInput.getText());
		m_numOfSensors = Integer.parseInt(m_numSensorInput.getText());
		m_algorithmChoice = new String(m_toggleGroup.getSelectedToggle().getUserData().toString());
	}
	
	private void executeSimulation()
	{
		Simulation simulation = new Simulation(m_numOfSensors, m_algorithmChoice);
		
		System.out.println("-- You chose the: " + simulation.getAlgorithmName()
							+ " algorithm");
	}
	
	
}













