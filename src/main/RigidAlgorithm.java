package main;

import java.util.Collections;
import java.util.Comparator;

import main.Sensor;

public class RigidAlgorithm extends Algorithm {	
	
	public RigidAlgorithm(int numSensors, double rad) {
		super(numSensors, rad);
	}
	
	public RigidAlgorithm(Simulation sim) {
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
			
		//initial movement
		totalMovement += sensors.get(0).moveTo(radius);
		
		//move sensor if there is gap between it and the one to left of it
		//ignore overlap
		for (int ID = 1; ID < sensors.size(); ID++) {
			if (sensors.get(ID - 1).getCenter() + (2*radius) < 1) {
				totalMovement += sensors.get(ID).moveTo(sensors.get(ID - 1).getCenter() + (2*radius));
			}
		}
		
		printSensors();
		return totalMovement;
	}
}