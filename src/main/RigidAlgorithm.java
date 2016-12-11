package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import main.Sensor;

public class RigidAlgorithm {
	
	ArrayList<Sensor> sensors;
	double radius;
	
	double OccupiedCoordinate;
	double totalMovement;
	int n = 0;
	int numSensors;
	
	
	public RigidAlgorithm(int numSensors, double rad) {
		sensors = makeRandSensors(numSensors);
		this.numSensors = numSensors;
		totalMovement = 0;
		radius = rad;
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
		if (sensors.get(0).getCenter() < radius) {
			totalMovement += sensors.get(0).moveTo(radius);
		}
		
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
	
	private void printSensors() {
		for (int i = 0; i < sensors.size(); i++) {
			System.out.print("Sensor " + (i+1) + " = " + sensors.get(i).getCenter() + "\n");
		}
	}
	
	public ArrayList<Sensor> makeRandSensors(int numSensors) {
		ArrayList<Sensor> array = new ArrayList<Sensor>();		
		Random generator = new Random();
		for (int i = 0; i < numSensors; i++) {
			array.add(new Sensor(radius, false, generator.nextFloat()));
		}	
		return array;
	}
}