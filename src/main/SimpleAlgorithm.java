package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SimpleAlgorithm {
	
	ArrayList<Sensor> sensors;
	double radius;
	double totalMovement;
	
	public SimpleAlgorithm(int numSensors, double rad) {
		sensors = makeRandSensors(numSensors);
		radius = rad; //Takes 20 sensors to cover entire interval. 
		totalMovement = 0;
	}
	
	public SimpleAlgorithm(Simulation sim) {
		sensors = sim.getSensors();
		radius = sim.getSensorRadius();
		totalMovement = 0;
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
			sensors.get(0).setCenter(radius);
		}
		
		//move sensor if there is gap between it and the one to left of it
		//ignore overlap
		for (int ID = 1; ID < sensors.size(); ID++) {
			
			if (sensors.get(ID).getCenter() - sensors.get(ID - 1).getCenter() > 2*radius) {
				totalMovement += sensors.get(ID).getCenter() - (sensors.get(ID-1).getCenter() + (radius*2));
				sensors.get(ID).setCenter(sensors.get(ID - 1).getCenter() + (2*radius));
			}
		}
		
		printSensors();
		return totalMovement;
	}
	
	//prints all the sensors with their current x-coordinate on interval
	private void printSensors() {
		for (int i = 0; i < sensors.size(); i++) {
			System.out.print("Sensor " + (i+1) + " = " + sensors.get(i).getCenter() + "\n");
		}
		
		System.out.println("Total Movement: " + totalMovement);
	}
	
	//Creates a random array list of Sensor type objects
	//Used for testing purposes - should not be needed in final
	public ArrayList<Sensor> makeRandSensors(int numSensors) {
		ArrayList<Sensor> array = new ArrayList<Sensor>();		
		Random generator = new Random();
		for (int i = 0; i < numSensors; i++) {
			array.add(new Sensor(radius, false, generator.nextFloat()));
		}	
		return array;
	}

}
