package Scenes;

import java.util.HashMap; 
import javafx.application.Application;
import javafx.stage.Stage;
import main.Graphing;
import main.AlgorithmController;

public class GraphTest extends Application{
	@Override public void start(Stage stage) {
    	HashMap<Double,Double> dataSeries1 = new HashMap<Double, Double>(); 
    	dataSeries1.put(Math.random(),Math.random());
    	dataSeries1.put(Math.random(),Math.random());
    	dataSeries1.put(Math.random(),Math.random());
    	dataSeries1.put(Math.random(),Math.random());
    	
    	HashMap<Double,Double> dataSeries2 = new HashMap<Double, Double>(); 
    	dataSeries2.put(Math.random(),Math.random());
    	dataSeries2.put(Math.random(),Math.random());
    	dataSeries2.put(Math.random(),Math.random());
    	dataSeries2.put(Math.random(),Math.random());
    	
    	HashMap<Double,Double> dataSeries3 = new HashMap<Double, Double>(); 
    	dataSeries3.put(Math.random(),Math.random());
    	dataSeries3.put(Math.random(),Math.random());
    	dataSeries3.put(Math.random(),Math.random());
    	dataSeries3.put(Math.random(),Math.random());
    	
        stage.setTitle("Comp3203");
        
        int runTimes = 200;
        int numSensors = 7;
        double radius = 0.1;
        
        AlgorithmController rigid = new AlgorithmController("RIGID_COVERAGE");
        AlgorithmController simple = new AlgorithmController("SIMPLE_COVERAGE");
        AlgorithmController overlap = new AlgorithmController("OVERLAP_COVERAGE");
        
        GraphScene graph = new GraphScene();
        graph.getGraph().createSeries("RigidAlgorithm",rigid.buildHashMap(runTimes, numSensors, radius));
        graph.getGraph().createSeries("SimpleAlgorithm",simple.buildHashMap(runTimes, numSensors, radius));
        graph.getGraph().createSeries("OverlapAlgorithm",overlap.buildHashMap(runTimes, numSensors, radius));
        
        graph.getGraph().setNumSensor(10);
        stage.setScene(graph.getGraphScene());
        
        stage.show();       
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
