// ======================================================================================
// FILE: Sensor.java
// CREATION DATE: OCT 20, 2016
// ABOUT: The sensor object.
// ======================================================================================

package main;

public class Sensor 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private float m_distanceToZero;
	private float m_distanceToOne;
	private float m_center;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Sensor()
	{
		
	}
	
	// ----------------------------------------------------------------------------------
	// Methods
	
	public float getDistanceToZero()
	{
		return m_distanceToZero;
	}
	
	public float getDistanceToOne()
	{
		return m_distanceToOne;
	}
	
	public float getCenter()
	{
		return m_center;
	}
	
	public void setCenter(
		float i_position
		)
	{
		m_center = i_position;
	}
}
