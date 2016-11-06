// ======================================================================================
// FILE: GraphingScene.java
// CREATION DATE: OCT 26, 2016
// ABOUT: Sets up the graphing scene and creates data series that are added to the scene. 
// ======================================================================================

package main;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Graphing {
	//Attributes --------------------------------------------------------------
	NumberAxis xAxis, yAxis;
	LineChart<Number,Number> lineChart;
	
	//Constructor -------------------------------------------------------------
	public Graphing(){
		createGraphingScene();
	}
	
	//Methods -----------------------------------------------------------------
	private void createGraphingScene() {
		xAxis = new NumberAxis();
		xAxis.setLabel("Radius");
		
        yAxis = new NumberAxis();
        yAxis.setLabel("Total Movement");
        
        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Radius Vs. Movement Relationships");    
	}

	public LineChart<Number,Number> getGraphing(){
		return lineChart;
	}
	
	public void createSeries(String name,HashMap<Float,Float> dataSeries){		
		Series<Number, Number> series = new XYChart.Series();
		series.setName(name);
		for (HashMap.Entry<Float, Float> x : dataSeries.entrySet()) {;		    
		    series.getData().add(new XYChart.Data(x.getKey(),x.getValue()));
		}
		lineChart.getData().add(series);
	}
	
	
}
