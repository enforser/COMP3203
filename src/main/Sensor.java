// ======================================================================================
// FILE: Sensor.java
// CREATION DATE: OCT 20, 2016
// ABOUT: The sensor object. Perhaps should have a shape (e.g. a circle)
// ======================================================================================

package main;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import utilities.ToolBelt;

public class Sensor 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private double m_distanceToZero;
	private double m_distanceToOne;
	private double m_center;
	private double m_startingCenter;
	private TranslateTransition m_animation;
	private ToolBelt m_toolBelt;
	
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
			m_toolBelt = new ToolBelt();
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
	
	
	
	public void moveTo(
		double i_position
		)
	{
		double scaledPosition = m_toolBelt.calculateScaledPosition(i_position);
		
		m_animation.setToX(scaledPosition);
	}
	
	
	public void move()
	{
		m_animation.play();
	}
	
	// ----------------------------------------------------------------------------------
	// Helper Functions
	
	private void initializeAnimationPath()
	{
		double initialPosition = m_toolBelt.calculateScaledPosition(m_startingCenter);
		
		m_animation = new TranslateTransition();
		m_animation.setDuration(Duration.seconds(8));
		m_animation.setFromX(initialPosition);
	}
}

























