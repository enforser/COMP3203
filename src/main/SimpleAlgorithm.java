package main;

import java.util.Collections;
import java.util.Comparator;

public class SimpleAlgorithm extends Algorithm {
	
	public SimpleAlgorithm(int numSensors, double rad) {
		super(numSensors, rad);
	}
	
	public SimpleAlgorithm(Simulation sim) {
		super(sim);
	}
	
	public double run() {
		
        //System.out.println("Running the Simple Algorithm");
		
		Collections.sort(sensors, new Comparator<Sensor>() {
	        @Override
	        public int compare(Sensor o1, Sensor o2) {
	            return Double.compare(o1.getCenter(),o2.getCenter());
	        }
	    });
		
		if (!intervalIsFull()) {
			
			//initial movement
			if (sensors.get(0).getCenter() > radius) {
				totalMovement += sensors.get(0).moveTo(radius);
			}
			
			//move sensor if there is gap between it and the one to left of it
			//ignore overlap
			for (int ID = 1; ID < sensors.size(); ID++) {
				
				if (sensors.get(ID).getCenter() - sensors.get(ID - 1).getCenter() > 2*radius) {
					totalMovement += sensors.get(ID).moveTo(sensors.get(ID - 1).getCenter() + (2*radius));
				}
			}
		}
		
		printSensors();
		return totalMovement;
	}
}
