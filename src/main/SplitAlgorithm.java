package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SplitAlgorithm {
	
	ArrayList<Sensor> sensors;
	double radius;
	double totalMovement;
	
	public SplitAlgorithm(int numSensors, double rad) {
		sensors = makeRandSensors(numSensors);
		radius = rad; //Takes 20 sensors to cover entire interval. 
		totalMovement = 0;
	}
	
	public SplitAlgorithm(Simulation sim) {
		sensors = sim.getSensors();
		radius = sim.getSensorRadius();
		totalMovement = 0;
	}
	
	public double run() {
		
        //System.out.println("Running the Fors Algorithm");
		
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
		totalMovement += Math.abs(sensors.get(rightID).getCenter() - (1 - radius));
		totalMovement += Math.abs(sensors.get(leftID).getCenter() - (radius));
		sensors.get(rightID).setCenter(1- radius);
		sensors.get(leftID).setCenter(radius);
		
		//
		while (leftID < rightID) {
			
			//SET ID'S FOR CURRENT ITERATION
			rightID--;
			leftID++;
			prevRightID = rightID + 1;
			prevLeftID = leftID - 1;
			
			//check if current sensors are touching each other
			if(Math.abs(sensors.get(rightID).getCenter() - sensors.get(leftID).getCenter()) <= (radius*2)) {
				break;
			}
			//move the sensors
			else {
				
				totalMovement += Math.abs(sensors.get(rightID).getCenter() - (sensors.get(prevRightID).getCenter() - (radius*2)));
				totalMovement += Math.abs(sensors.get(leftID).getCenter() - (sensors.get(prevLeftID).getCenter() + (radius*2)));
				
				sensors.get(rightID).setCenter(
						sensors.get(prevRightID).getCenter() - (radius*2));
				sensors.get(leftID).setCenter(
						sensors.get(prevLeftID).getCenter() + (radius*2));
			}
			
			
			//change the IDs
			
		}
		//System.out.print("After:\n");
		printSensors();
		
		return totalMovement;
	}
	
	private void printSensors() {
		for (int i = 0; i < sensors.size(); i++) {
			System.out.print("Sensor " + (i+1) + " = " + sensors.get(i).getCenter() + "\n");
		}
		
		System.out.println("Total Movement: " + totalMovement);
	}
	
	public ArrayList<Sensor> makeRandSensors(int numSensors) {
		ArrayList<Sensor> array = new ArrayList<Sensor>();		
		Random generator = new Random();
		for (int i = 0; i < numSensors; i++) {
			array.add(new Sensor(generator.nextFloat()));
		}	
		return array;
	}

}
