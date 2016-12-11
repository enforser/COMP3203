// ======================================================================================
// FILE: Simulation.java
// CREATION DATE: OCT 20, 2016
// ABOUT: Contains all knowledge about each simulation run. 
// ======================================================================================

package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Scenes.GraphScene;
import utilities.Constants;

public class Simulation 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	//This constant dictates how many runs would be average for each point on the graph 
	private final int GRAPH_RUNTIMES = 50; 
	
	private int m_numOfSensors;
	
	private double m_sensorRadius;
	
	private String m_algorithmName;
	
	private ArrayList<Sensor> m_sensors;
	
	private boolean m_hasAnimation;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Simulation(
		int i_numOfSensors,
		double i_sensorRadius,
		String i_algorithm
		)
	{
		m_numOfSensors = i_numOfSensors;
		m_sensorRadius = i_sensorRadius;
		m_algorithmName = new String(i_algorithm);
		
		animationGoOrNoGo(m_numOfSensors);
		
		m_sensors = new ArrayList<Sensor>();
		
		generateSensors();
		
		callAlgorithm(m_algorithmName);
	}
	
	// ----------------------------------------------------------------------------------
	// Methods
	
	public int getNumOfSensors()
	{
		return m_numOfSensors;
	}
		
	
	
	public double getSensorRadius()
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
	
	
	
	public boolean hasAnimation()
	{
		return m_hasAnimation;
	}
	
	// ----------------------------------------------------------------------------------
	// Helper Functions
	
	private void animationGoOrNoGo(
		int i_numOfSensors
		)
	{
		if (i_numOfSensors <= Constants.MAX_SENSORS_ANIME)
		{
			m_hasAnimation = true;
		}
	}
	
	private void generateSensors()
	{
		SensorFactory sensorFactory = new SensorFactory();
				
		for (int i = 0; i < m_numOfSensors; i++)
		{
			Sensor sensor = sensorFactory.createSensor(m_sensorRadius, m_hasAnimation);
			m_sensors.add(sensor);
		}
		
		System.out.println("-- " + m_numOfSensors + " sensors created!");
	}
	
	private void callAlgorithm(
		String i_algorithmName
		)
	{
		
		AlgorithmController ac;
		
		if(i_algorithmName.equals(AlgorithmType.SIMPLE_COVERAGE.toString())) {
			SimpleAlgorithm algo = new SimpleAlgorithm(this);
			algo.run();
		}
		else if(i_algorithmName.equals(AlgorithmType.RIGID_COVERAGE.toString())) {
			RigidAlgorithm algo = new RigidAlgorithm(this);
			algo.run();
		}
		else if(i_algorithmName.equals(AlgorithmType.OVERLAP_COVERAGE.toString())) {
			OverlapAlgorithm algo = new OverlapAlgorithm(this);
			algo.run();
		}
		else if (i_algorithmName.equals(AlgorithmType.SPLIT_COVERAGE.toString())) {
			SplitAlgorithm algo = new SplitAlgorithm(this);
			algo.run();
		}
		else {
			System.out.println("-- Selected Invalid Algorithm");
			//an algorithm was requested that does not exist
		}	
	}
	
	public void generateGraphData(GraphScene m_graphingScene){
		m_graphingScene.getGraph().setNumSensor(getNumOfSensors());
		
		AlgorithmController rigid = new AlgorithmController("RIGID_COVERAGE");
        AlgorithmController simple = new AlgorithmController("SIMPLE_COVERAGE");
        AlgorithmController overlap = new AlgorithmController("OVERLAP_COVERAGE");
        
        m_graphingScene.getGraph().createSeries("RigidAlgorithm",rigid.buildHashMap(GRAPH_RUNTIMES,getNumOfSensors(),getSensorRadius()));
        m_graphingScene.getGraph().createSeries("SimpleAlgorithm",simple.buildHashMap(GRAPH_RUNTIMES,getNumOfSensors(),getSensorRadius()));
        m_graphingScene.getGraph().createSeries("OverlapAlgorithm",overlap.buildHashMap(GRAPH_RUNTIMES,getNumOfSensors(),getSensorRadius()));
	}
}
