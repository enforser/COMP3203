package main;

import java.util.ArrayList;
import java.util.Random;

public class Algorithm {
	
	ArrayList<Sensor> sensors;
	double radius;
	double totalMovement;
	
	public Algorithm(int numSensors, double rad) {
		sensors = makeRandSensors(numSensors);
		radius = rad; //Takes 20 sensors to cover entire interval. 
		totalMovement = 0;
	}
	
	public Algorithm(Simulation sim) {
		sensors = sim.getSensors();
		radius = sim.getSensorRadius();
		totalMovement = 0;
	}
	
	//prints all the sensors with their current x-coordinate on interval
	protected void printSensors() {
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
