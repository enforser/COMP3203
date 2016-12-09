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
	
	private double m_distanceToZero;
	private double m_distanceToOne;
	private double m_center;
	private double m_startingCenter;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Sensor()
	{
		//default
	}
	
	public Sensor(double i_initialCenter)
	{
		//System.out.println("-- Sensor center: " + i_initialCenter);
		
		this.m_center = i_initialCenter;
		this.m_distanceToOne = 1 - i_initialCenter;
		this.m_distanceToZero = i_initialCenter;	
		this.m_startingCenter = i_initialCenter;
	}
	
	// ----------------------------------------------------------------------------------
	// Methods
	
	public double getDistanceToZero()
	{
		return m_distanceToZero;
	}
	
	public double getDistanceToOne()
	{
		return m_distanceToOne;
	}
	
	public double getCenter()
	{
		return m_center;
	}
	
	public double getStartCenter(){
		return this.m_startingCenter;
	}
	
	public void setCenter(
		double i_position
		)
	{
		m_center = i_position;
	}
}
