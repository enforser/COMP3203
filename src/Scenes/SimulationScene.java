// ======================================================================================
// FILE: SimulationScene.java
// CREATION DATE: OCT 19, 2016
// ABOUT: Potentially responsible for displaying the pictorial interface to illustrate
//        sensor movement.
// ======================================================================================

package Scenes;

import CustomExceptions.InvalidChoiceException;
import CustomExceptions.InvalidInputException;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.AlgorithmType;
import main.InputVerifier;
import main.Simulation;
import utilities.Constants;

public class SimulationScene
{
	// ----------------------------------------------------------------------------------
	// Properties

	private InputVerifier m_inputVerifier;
	private Simulation m_simulation;

	// ----------------------------------------------------------------------------------
	// GUI Properties

	private Scene m_simulationScene;

	private GridPane m_grid;
	private GridPane m_animationGrid;

	private Label m_sensorInputLabel;
	private Label m_radiusInputLabel;

	private TextField m_numSensorInput;
	private TextField m_radiusInput;

	private Separator m_separator;

	private ToggleGroup m_toggleGroup;
	private RadioButton m_rigidRadio;
	private RadioButton m_simpleRadio;

	private Button m_confirmInputButton;
	private Button m_runSimulationButton;
	private Button m_viewDataButton;

	private final int SCENE_WIDTH = Constants.SCENE_WIDTH;
	private final int SCENE_HEIGHT = Constants.SCENE_HEIGHT;

	private Path m_animationPath;

	private Group m_animationGroup;

	private Label testLabel; // delete this later

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
		m_inputVerifier = new InputVerifier();
	}

	public Scene getSimulationScene()
	{
		return m_simulationScene;
	}

	public Simulation getSimulation()
	{
		return m_simulation;
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
				m_confirmInputButton,
				m_runSimulationButton,
				m_viewDataButton);
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

		m_confirmInputButton = new Button("Confirm Input");
		m_confirmInputButton.setTooltip(new Tooltip("Click to start simulation"));
		m_confirmInputButton.setOnMouseReleased(e -> {
			System.out.println("-- Confirm Input button was clicked");
			attemptSimulation();
		});
		GridPane.setConstraints(m_confirmInputButton, 0, 4);

		m_runSimulationButton = new Button("Run Simulation");
		m_runSimulationButton.setTooltip(new Tooltip("Click to animate simulation"));
		m_runSimulationButton.setDisable(true);
		m_runSimulationButton.setOnMouseReleased(e -> {
			System.out.println("-- Run Simulation button was clicked");
			//// openSimulationWindow();
		});
		GridPane.setConstraints(m_runSimulationButton, 1, 4);
		
		m_viewDataButton = new Button("View Data");
		m_viewDataButton.setTooltip(new Tooltip("Click to view data and graph"));
		m_viewDataButton.setDisable(true);
		m_viewDataButton.setOnMouseReleased(e ->{
			System.out.println("-- View Data button was clicked");
			// open graph scene
		});
		GridPane.setConstraints(m_viewDataButton, 2, 4);
	}

	private void attemptSimulation()
	{
		try
		{
			verifyUserInput();
			createSimulation();
		}
		catch (InvalidChoiceException e1)
		{
			System.out.println(e1);
		}
		catch (InvalidInputException e2)
		{
			System.out.println(e2);
		}
	}

	private void verifyUserInput() throws InvalidChoiceException, InvalidInputException
	{
		m_inputVerifier.isInt(m_numSensorInput, m_numSensorInput.getText());
		m_inputVerifier.isFloat(m_radiusInput, m_radiusInput.getText());
		m_inputVerifier.verifyChoiceValidity(m_toggleGroup);
	}

	private void createSimulation()
	{
		m_simulation = new Simulation(
			m_inputVerifier.getVerifiedNumOfSensors(),
			m_inputVerifier.getVerifiedSensorRadius(),
			m_inputVerifier.getVerifiedAlgorithmChoice());

		System.out.println("-- You chose the: " + m_simulation.getAlgorithmName()
							+ " algorithm");

		if (m_simulation.getNumOfSensors() <= 10)
		{
			enableButton(m_runSimulationButton);

			int index = 0;
			if (m_grid.getChildren().contains(testLabel))
			{

			index = m_grid.getChildren().indexOf(testLabel);
			}
			if (index != 0)
			{
				m_grid.getChildren().remove(index);
			}

			testLabel = new Label("Test Label");
			GridPane.setConstraints(testLabel, 0, 5);

			constructAnimationPath();

			//----
			///final Stage dialog = new Stage();
            ///dialog.initModality(Modality.NONE);
            //dialog.initOwner();
            ///VBox dialogVbox = new VBox(20);
            ///dialogVbox.getChildren().add(new Text("Animation will go in this window"));
            ///Scene dialogScene = new Scene(dialogVbox, 300, 200);
            ///dialog.setScene(dialogScene);
            ///dialog.show();

			///---
		}
		else
		{
			disableButton(m_runSimulationButton);
		}
	}

	// DEC 8 working on this function ...
	private void prepareAnimatedSimulation()
	{
		final Group animationGroup = new Group();
	}

	// DEC 8
	private void constructAnimationPath()
	{
		Rectangle sensor = new Rectangle(20, 5);
		Rectangle sensors = new Rectangle()
		
		Line unitInterval = new Line();
		
		unitInterval.setStartX(0);
		unitInterval.setEndX(1000);
		//GridPane.setConstraints(sensor, 1, 7);
		//sensor.relocate(800, 500);

		m_animationGrid = new GridPane();
		m_animationGrid.getChildren().addAll(unitInterval, sensor);
		m_grid.getChildren().add(m_animationGrid);
		GridPane.setConstraints(m_animationGrid, 0, 8, 8, 1);

		/* PATH TRANSITIONS WAS NOT WORKING

		m_grid.getChildren().add(m_animationGroup);
		GridPane.setConstraints(m_animationGroup, 0, 7, 6, 1);


		m_animationPath = new Path();
		m_animationPath.getElements().add(new MoveTo(800, 0));
		m_animationPath.getElements().add(new LineTo(300, 0));
		m_animationPath.setOpacity(0);
		//m_animationPath.getElements().add(new LineTo(Constants.PATH_LENGTH, 0));
		//GridPane.setConstraints(m_animationPath, 1, 7, 6, 1);
		//m_animationGroup.getChildren().add(m_animationPath);
		//m_animationGroup.getChildren().add(sensor);

		PathTransition pt = new PathTransition();

		pt.setDuration(Duration.seconds(8.0));
		pt.setDelay(Duration.seconds(.5));
		pt.setPath(m_animationPath);
		pt.setNode(sensor);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(1);
		m_animationGroup.getChildren().add(sensor);
		pt.playFromStart();
		*/

		// Testing Rightward Movement of Sensor ----------------------------------------------
		TranslateTransition tt = new TranslateTransition();
		tt.setNode(sensor);
		tt.setFromX(500);


		tt.setToX(0);


		tt.setCycleCount(1);
		tt.setDuration(Duration.seconds(8.0));
		//tt.setDelay(Duration.seconds(0.5));
		tt.play();



	}

	private void enableButton(
		Button button
		)
	{
		button.setDisable(false);
	}

	private void disableButton(
		Button button
		)
	{
		button.setDisable(true);
	}


}
