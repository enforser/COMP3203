package main;

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
	
	public HashMap<Double, Double> buildHashMap(int runTimes, int numSensors, double radius) {
		HashMap<Double,Double> data = new HashMap<Double, Double>(); 
		
		/*
	    	dataSeries1.put(Math.random(),Math.random());
	    	dataSeries1.put(Math.random(),Math.random());
	    	dataSeries1.put(Math.random(),Math.random());
	    	dataSeries1.put(Math.random(),Math.random());
    	*/
		
		//x axis = radius = key
		//y axis = total movement = value
		
		//build radius array
		double xIncrement = (radius*2)/5;
		int xAxisSize = 10;
		double[] xValues = new double[xAxisSize];
		
		for(int i = 0; i < xAxisSize; i++) {
			double currIncrement = xIncrement*(i - (xAxisSize/2));
			xValues[i] = radius + currIncrement;
			data.put(xValues[i], getRunAverage(runTimes, numSensors, radius));
		}
		System.out.println(data);
		return data;
	}
	
}
