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
	
	
	public RigidAlgorithm(int numSensors, float rad) {
		sensors = makeRandSensors(numSensors);
		this.numSensors = numSensors;
		radius = rad;
	}
	
	public void run() {
		System.out.println("Running the Rigid Algorithm");
		
		Collections.sort(sensors, new Comparator<Sensor>() {
	        @Override
	        public int compare(Sensor o1, Sensor o2) {
	            return Double.compare(o1.getCenter(),o2.getCenter());
	        }
	    });
		
		printSensors();
		
		Sensor currSensor = null;
		
		currSensor = sensors.get(n);
		
		System.out.println("After the Algorithm");
		
		//check to see if the left most sensor is in the right place
		if((currSensor.getCenter() - radius) != 0.0){
			totalMovement = Math.abs(radius - currSensor.getCenter());
			currSensor.setCenter(radius);
			OccupiedCoordinate = currSensor.getCenter() + radius;
		}
		
		//Move the remaining sensors		
		while(true){			
			if(n >= this.numSensors || this.OccupiedCoordinate >= 1){
				break;
			}
			
			//find the immediate right sensor
			currSensor = sensors.get(++n);
			
			if((currSensor.getCenter() - radius) == OccupiedCoordinate){
				//we are at optimal location already...
			}
			else if((currSensor.getCenter() - radius) > OccupiedCoordinate){
				//move the sensor
				totalMovement += Math.abs((OccupiedCoordinate+radius) - currSensor.getCenter());
				currSensor.setCenter(OccupiedCoordinate+radius);
				OccupiedCoordinate = currSensor.getCenter() + radius;
			}
			else if((currSensor.getCenter() - radius) < OccupiedCoordinate){
				//move the sensor
				totalMovement += Math.abs((OccupiedCoordinate+radius) - currSensor.getCenter());
				currSensor.setCenter(OccupiedCoordinate+radius);
				OccupiedCoordinate = currSensor.getCenter() + radius;
			}			
		}
		printSensors();
		
		System.out.println("Total Movement: "+totalMovement);
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