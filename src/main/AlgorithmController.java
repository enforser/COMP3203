package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AlgorithmController {

	private String algoType;
	
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
	
    public ArrayList<Double> generateGraphIntervals(double rad){
    	ArrayList<Double> list = new ArrayList<Double>();  	
    	double interval = ((rad*2)-rad)/10;  	
    	list.add(rad); 	
    	for(int i=0; i<10;i++){
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
