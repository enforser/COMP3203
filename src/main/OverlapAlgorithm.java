package main;


import java.util.Collections;
import java.util.Comparator;

public class OverlapAlgorithm extends Algorithm {
	
	public OverlapAlgorithm(int numSensors, double rad) {
		super(numSensors, rad);
	}
	
	public OverlapAlgorithm(Simulation sim) {
		super(sim);
	}
	
	public double run() {
		
        //System.out.println("Running the Fors Algorithm");
		
		Collections.sort(sensors, new Comparator<Sensor>() {
	        @Override
	        public int compare(Sensor o1, Sensor o2) {
	            return Double.compare(o1.getCenter(),o2.getCenter());
	        }
	    });
		
		int n = sensors.size();
		int currID = sensors.size() - 1;
		int prevID = sensors.size();
		
		//This is the total amount of allowed overlap
		//The total possible amount of distance covered with sensors (2nr) minus the size of the interval (1). 
		double overlap = ((2*n*radius)-1);
		
		if (n < ((1/2)*radius)) {
			System.out.println("Cannot cover entire interval");
		}
		
		//Starting with right most sensor
		//  if not touching right side of interval then move it until it touches
		//  else remove amount of space lying outside interval from allowed overlap
		if (sensors.get(currID).getCenter() + radius < 1 || overlap <= radius) {
			totalMovement += sensors.get(currID).moveTo(1 - radius);
		}
		else {
			overlap = overlap - (sensors.get(currID).getCenter() - 1);
		}
		
		//Now that we have dealt with right most sensor, move to next one
		currID--;
		prevID--;
				
		while (currID >= 0) {
			
			//move the left sensor to the right sensor leaving no space 
			//between radiuses while creating no overlap between radiuses
			if (overlap <= 0) {
				totalMovement += sensors.get(currID).moveTo((sensors.get(prevID).getCenter() - (2*radius)));
			}
			//if there is space between the current sensor and the previous 
			//one then move current until it touches previous
			else if (sensors.get(prevID).getCenter() - sensors.get(currID).getCenter() > (2*radius)) {
				totalMovement += sensors.get(currID).moveTo((sensors.get(prevID).getCenter() - (2*radius)));
			}
			//if there is no space between the two sensors then figure out
			//the amount of overlap the two sensors have and take it 
			//away from the total amount of overlap we can still afford. 
			else {
				double space = (sensors.get(currID).getCenter() + radius) - (sensors.get(prevID).getCenter() - radius);
				
				//if overlap -space is less than 0, then we want to move the sensor.set(currID, sensor.get(currID) - overlap)) and set overlap = 0.
				//otherwise don't move and overlap -= space
				
				overlap -= space;
			}
			
			currID--;
			prevID--;
			
		}
		//System.out.print("After:\n");
		printSensors();
		return totalMovement;
	}
}
