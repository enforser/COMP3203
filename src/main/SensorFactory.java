// ======================================================================================
// FILE: SensorFactory.java
// CREATION DATE: OCT 20, 2016
// ABOUT: Responsible for creating new Sensors
// ======================================================================================

package main;

public class SensorFactory 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private RandomPositionGenerator m_randomPositionGenerator;
	
	// ----------------------------------------------------------------------------------
	// Constructors
	
	SensorFactory()
	{
		m_randomPositionGenerator = new RandomPositionGenerator();
	}
	
	// ----------------------------------------------------------------------------------
	// Methods
		
	public Sensor createSensor(
		double i_radius,
		boolean i_hasAnimation
		)
	{
		double randomStartPosition = m_randomPositionGenerator.generateRandomPosition();
		
		Sensor sensor = new Sensor(i_radius, i_hasAnimation, randomStartPosition);
		
		return sensor;
		
	}
}
