package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Algorithm {
	
	ArrayList<Double> sensors;
	double radius;
	
	public Algorithm(int numSensors, double rad) {
		sensors = makeRandSensors(numSensors);
		radius = rad; //Takes 20 sensors to cover entire interval. 
	}
	
	public void run() {
		
		System.out.print("\n\nBefore:\n");
		printSensors();
		System.out.print("\n\n\n");
		
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
		if (sensors.get(currID) + radius < 1 || overlap <= radius) {
			sensors.set(currID, 1 - radius);
		}
		else {
			overlap = overlap - (sensors.get(currID) - 1);
		}
		
		//Now that we have dealt with right most sensor, move to next one
		currID--;
		prevID--;
				
		while (currID >= 0) {
			
			//move the left sensor to the right sensor leaving no space 
			//between radiuses while creating no overlap between radiuses
			if (overlap <= 0) {
				sensors.set(currID, (sensors.get(prevID) - (2*radius)));
			}
			//if there is space between the current sensor and the previous 
			//one then move current until it touches previous
			else if (sensors.get(prevID) - sensors.get(currID) > (2*radius)) {
				sensors.set(currID, (sensors.get(prevID) - (2*radius)));
			}
			//if there is no space between the two sensors then figure out
			//the amount of overlap the two sensors have and take it 
			//away from the total amount of overlap we can still afford. 
			else {
				double space = (sensors.get(currID) + radius) - (sensors.get(prevID) - radius);
				
				//if overlap -space is less than 0, then we want to move the sensor.set(currID, sensor.get(currID) - overlap)) and set overlap = 0.
				//otherwise don't move and overlap -= space
				
				overlap -= space;
			}
			
			currID--;
			prevID--;
			
		}
		System.out.print("After:\n");
		printSensors();
	}
	
	private void printSensors() {
		for (int i = 0; i < sensors.size(); i++) {
			System.out.print("Sensor " + (i+1) + " = " + sensors.get(i) + "\n");
		}
	}
	
	public ArrayList<Double> makeRandSensors(int numSensors) {
		ArrayList<Double> array = new ArrayList<Double>();
		
		Random generator = new Random();
	
		for (int i = 0; i < numSensors; i++) {
			array.add(generator.nextDouble());
		}
		
		Collections.sort(array);
		return array;
	}

}
