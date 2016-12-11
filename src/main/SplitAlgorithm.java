package main;

import java.util.Collections;
import java.util.Comparator;

public class SplitAlgorithm extends Algorithm {
	
	public SplitAlgorithm(int numSensors, double rad) {
		super(numSensors, rad);
	}
	
	public SplitAlgorithm(Simulation sim) {
		super(sim);
	}
	
	public double run() {
		
        //System.out.println("Running the Split Algorithm");
		
		Collections.sort(sensors, new Comparator<Sensor>() {
	        @Override
	        public int compare(Sensor o1, Sensor o2) {
	            return Double.compare(o1.getCenter(),o2.getCenter());
	        }
	    });
				
		int rightID = sensors.size() - 1;
		int leftID = 0;
		int prevRightID, prevLeftID;
		
		//set left most and right most to respective edges
		totalMovement += sensors.get(rightID).moveTo(1 - radius);
		totalMovement += sensors.get(leftID).moveTo(radius);
		
		//
		rightID--;
		leftID++;
		
		while (leftID <= rightID) {
			
			//SET ID'S FOR CURRENT ITERATION
			prevRightID = rightID +1;
			prevLeftID = leftID-1;
			
			//check if current sensors are touching each other
			if(Math.abs(sensors.get(rightID).getCenter() 
					- sensors.get(leftID).getCenter()) <= (radius*2)) {
				
				if(leftID == rightID) {
					totalMovement += sensors.get(leftID).moveTo(
							sensors.get(prevLeftID).getCenter() + (radius*2));
				}
				
				break;
			}
			//otherwise move the sensors to left or right, respectively
			else {
				
				//update the movement taking place
				//update the sensor objects being moved
				totalMovement += sensors.get(leftID).moveTo(
						sensors.get(prevLeftID).getCenter() + (radius*2));
				totalMovement += sensors.get(rightID).moveTo(
						sensors.get(prevRightID).getCenter() - (radius*2));
			}
			
			rightID--;
			leftID++;
		}
		printSensors();
		
		return totalMovement;
	}

}
