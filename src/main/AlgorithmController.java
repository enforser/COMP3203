package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AlgorithmController {

	private String algoType;
	
	//This constant dictates the min/max of the graphs intervals (radius +/- scale where 0 < intervals < 1)
	private final int INTERVAL_SCALE = 10;
	//This constant dictates how intervals between the radius and the min/max
	private final int INTERVAL_DIVISION = 20;
	
	public AlgorithmController(String algorithmType) {
		this.algoType = algorithmType;
	}
	
	public double run(int numSensors, double radius) {
		
		if (algoType.equals("SIMPLE_COVERAGE")) {
			SimpleAlgorithm algo = new SimpleAlgorithm(numSensors, radius);
			return algo.run();
		}
		else if (algoType.equals("RIGID_COVERAGE")) {
			RigidAlgorithm algo = new RigidAlgorithm(numSensors, radius);
			return algo.run();
		}
		else if (algoType.equals("OVERLAP_COVERAGE")) {
			OverlapAlgorithm algo = new OverlapAlgorithm(numSensors, radius);
			return algo.run();
		}
		else if (algoType.equals("SPLIT_COVERAGE")) {
			SplitAlgorithm algo = new SplitAlgorithm(numSensors, radius);
			return algo.run();
		}
		else {
			System.out.println("-- Invalid Algorithm Type");
		}
		
		return 0;
	}
	
	public double getRunAverage(int runTimes, int numSensors, double radius) {
		double totalMovement = 0; 
		
		for(int i = 0; i < runTimes; i++) {
			totalMovement += run(numSensors, radius);
		}
		
		return totalMovement/runTimes;
	}
	
	//returns an array with intervals indicating the x axis(radiuses) where 0 < interval < 1
    public ArrayList<Double> generateGraphIntervals(double rad){
    	ArrayList<Double> list = new ArrayList<Double>();  	
    	double interval = ((rad*INTERVAL_SCALE)-rad)/INTERVAL_DIVISION;  	
    	list.add(rad); 	
    	for(int i=0; i<INTERVAL_DIVISION;i++){
    		if(rad-(interval*(i+1)) > 0.0){
    			list.add(rad-(interval*(i+1)));
    		}
    		if(rad+(interval*(i+1)) < 1.0){
    			list.add(rad+(interval*(i+1)));
    		}
    	}
    	Collections.sort(list);
    	return list;
    }   
	
	public HashMap<Double, Double> buildHashMap(int runTimes, int numSensors, double radius) {
		HashMap<Double,Double> data = new HashMap<Double, Double>(); 
		
		//x axis = radius = key
		//y axis = total movement = value		
		/*
		double xIncrement = (radius*2)/5;
		int xAxisSize = 10;
		double[] xValues = new double[xAxisSize];
		
		for(int i = 0; i < xAxisSize; i++) {
			double currIncrement = xIncrement*(i - (xAxisSize/2));
			xValues[i] = radius + currIncrement;
			data.put(xValues[i], getRunAverage(runTimes, numSensors, radius));
		}
		*/
		
		ArrayList<Double> xValues = generateGraphIntervals(radius);
		for(double x : xValues){
			data.put(x, getRunAverage(runTimes, numSensors, radius));
		}
		
		System.out.println(data);
		return data;
	}
	
}
