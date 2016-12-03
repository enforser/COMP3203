// ======================================================================================
// FILE: Sensor.java
// CREATION DATE: OCT 20, 2016
// ABOUT: The sensor object. Perhaps should have a shape (e.g. a circle)
// ======================================================================================

package main;

public class Sensor 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private float m_distanceToZero;
	private float m_distanceToOne;
	private float m_center;
	private float m_startingCenter;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Sensor()
	{
		//default
	}
	
	public Sensor(float i_initialCenter)
	{
		this.m_center = i_initialCenter;
		this.m_distanceToOne = 1 - i_initialCenter;
		this.m_distanceToZero = i_initialCenter;	
		this.m_startingCenter = i_initialCenter;
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
	
	public float getStartCenter(){
		return this.m_startingCenter;
	}
	
	public void setCenter(
		float i_position
		)
	{
		m_center = i_position;
	}
}
