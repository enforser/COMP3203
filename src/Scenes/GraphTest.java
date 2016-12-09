package Scenes;

import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import main.Graphing;

public class GraphTest extends Application{
	@Override public void start(Stage stage) {
    	HashMap<Float,Float> dataSeries = new HashMap<Float, Float>(); 
    	dataSeries.put(0.8f,0.28f);
    	dataSeries.put(0.1f,0.84f);
    	dataSeries.put(0.5f,0.38f);
    	dataSeries.put(0.34f,0.45f);
    	
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
