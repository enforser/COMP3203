// ======================================================================================
// FILE: GraphingScene.java
// CREATION DATE: OCT 26, 2016
// ABOUT: Sets up the graphing scene and creates data series that are added to the scene. 
// ======================================================================================

package main;

import java.util.HashMap;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Graphing {
	//Attributes --------------------------------------------------------------
	NumberAxis xAxis, yAxis;
	LineChart<Number,Number> lineChart;
	String name;
	
	//Constructor -------------------------------------------------------------
	public Graphing(){
		this.name = "Radius Vs. Total Movement";
		createGraphingScene();
	}
	
	//Methods -----------------------------------------------------------------
	private void createGraphingScene() {
		xAxis = new NumberAxis();
		xAxis.setLabel("Radius");
		
        yAxis = new NumberAxis();
        yAxis.setLabel("Total Movement");
        
        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle(this.name);    
	}
	
	public void setNumSensor(int n){
		lineChart.setTitle(this.name + " with " + n + " sensors");   
	}

	public LineChart<Number,Number> getLChart(){
		return lineChart;
	}
	
	public void createSeries(String name,HashMap<Double,Double> dataSeries){		
		Series<Number, Number> series = new XYChart.Series();
		series.setName(name);
		for (HashMap.Entry<Double, Double> x : dataSeries.entrySet()) {;		    
		    series.getData().add(new XYChart.Data(x.getKey(),x.getValue()));
		}
		lineChart.getData().add(series);
	}	
}
