package Scenes;

import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import main.Graphing;

public class GraphTest extends Application{
	@Override public void start(Stage stage) {
    	HashMap<Double,Double> dataSeries = new HashMap<Double, Double>(); 
    	dataSeries.put(0.8,0.28);
    	dataSeries.put(0.1,0.84);
    	dataSeries.put(0.5,0.38);
    	dataSeries.put(0.34,0.45);
    	
        stage.setTitle("Comp3203");
        
        GraphScene graph = new GraphScene();
        graph.getGraph().createSeries("#S=1",dataSeries);
        
        stage.setScene(graph.getGraphScene());
        
        stage.show();       
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
