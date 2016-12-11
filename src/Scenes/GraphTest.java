package Scenes;

import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import main.Graphing;

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
        
        GraphScene graph = new GraphScene();
        graph.getGraph().createSeries("RigidAlgorithm",dataSeries1);
        graph.getGraph().createSeries("SimpleAlgorithm",dataSeries2);
        graph.getGraph().createSeries("OverlapAlgorithm",dataSeries3);
        
        graph.getGraph().setNumSensor(10);
        stage.setScene(graph.getGraphScene());
        
        stage.show();       
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
