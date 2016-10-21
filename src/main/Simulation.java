// ======================================================================================
// FILE: Simulation.java
// CREATION DATE: OCT 20, 2016
// ABOUT: Contains all knowledge about each simulation run. 
// ======================================================================================

package main;

import java.util.ArrayList;

public class Simulation 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private int m_numOfSensors;
	
	private float m_sensorRadius;
	
	private String m_algorithmName;
	
	private ArrayList<Sensor> m_sensors;
	
	private SensorFactory m_sensorFactory;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Simulation(
		int i_numOfSensors,
		String i_algorithm
		)
	{
		m_numOfSensors = i_numOfSensors;
		m_algorithmName = new String(i_algorithm);
		
		calculateSensorRadius();
		
		m_sensors = new ArrayList<Sensor>();
		m_sensorFactory = new SensorFactory();
		
		generateSensors();
	}
	
	// ----------------------------------------------------------------------------------
	// Methods
	
	public int getNumOfSensors()
	{
		return m_numOfSensors;
	}
		
	public float getSensorRadius()
	{
		return m_sensorRadius;
	}
	
	public String getAlgorithmName()
	{
		return m_algorithmName;
	}
		
	public ArrayList<Sensor> getSensors()
	{
		return m_sensors;
	}
	
	// ----------------------------------------------------------------------------------
	// Helper Functions
	
	private void calculateSensorRadius()
	{
		// Do some calculation using m_numOfSensors, I don't know the actual formula :P
		
		m_sensorRadius = m_numOfSensors/(2*m_numOfSensors);
	}
	
	private void generateSensors()
	{
		for (int i = 0; i < m_numOfSensors; i++)
		{
			Sensor sensor = m_sensorFactory.createSensor();
			m_sensors.add(sensor);
		}
		
		System.out.println("-- " + m_numOfSensors + " sensors created!");
	}
}
