// ======================================================================================
// FILE: Sensor.java
// CREATION DATE: OCT 20, 2016
// ABOUT: The sensor object. Perhaps should have a shape (e.g. a circle)
// ======================================================================================

package main;

import javafx.animation.TranslateTransition;

public class Sensor 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private double m_distanceToZero;
	private double m_distanceToOne;
	private double m_center;
	private double m_startingCenter;
	private TranslateTransition m_animation;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Sensor()
	{

	}
	
	public Sensor(
		double i_initialCenter,
		boolean i_hasAnimation
		)
	{
		//System.out.println("-- Sensor center: " + i_initialCenter);
		
		m_center = i_initialCenter;
		m_distanceToOne = 1 - i_initialCenter;
		m_distanceToZero = i_initialCenter;	
		m_startingCenter = i_initialCenter;
		
		if (i_hasAnimation)
		{
			initializeAnimationPath();
		}
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
	
	// ----------------------------------------------------------------------------------
	// Helper Functions
	
	private void initializeAnimationPath()
	{
		m_animation = new TranslateTransition();
		// initialPosition = ToolBelt.getScaledPosition(intialValue);
		//m_animation.setFromX();
		
	}
}

























