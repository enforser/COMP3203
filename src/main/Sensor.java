// ======================================================================================
// FILE: Sensor.java
// CREATION DATE: OCT 20, 2016
// ABOUT: The sensor object. Perhaps should have a shape (e.g. a circle)
// ======================================================================================

package main;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import utilities.Constants;
import utilities.ToolBelt;

public class Sensor 
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private double m_distanceToZero;
	private double m_distanceToOne;
	private double m_center;
	private double m_startingCenter;
	private double m_radius;
	private Rectangle m_visualSensor;
	
	private TranslateTransition m_animation;
	private ToolBelt m_toolBelt;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	public Sensor(
		double i_sensorRadius,
		boolean i_hasAnimation,
		double i_startPosition
		)
	{
		//System.out.println("-- Sensor center: " + i_initialCenter);
			
		m_radius = i_sensorRadius;
		m_center = i_startPosition;
		m_distanceToOne = 1 - i_startPosition;
		m_distanceToZero = i_startPosition;	
		m_startingCenter = i_startPosition;
			
		if (i_hasAnimation)
		{
			m_toolBelt = new ToolBelt();
			generateVisualSensor();
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
	
	
	public double getRadius()
	{
		return m_radius;
	}
	
	
	public Rectangle getVisualSensor()
	{
		return m_visualSensor;
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
	
	private void generateVisualSensor()
	{
		double scaledRadius = m_toolBelt.calculateScaledRadius(m_radius);
		
		m_visualSensor = new Rectangle(scaledRadius, Constants.SENSOR_HEIGHT);
	}
	
	private void initializeAnimationPath()
	{
		double initialPosition = m_toolBelt.calculateScaledPosition(m_startingCenter);
		
		m_animation = new TranslateTransition();
		m_animation.setNode(m_visualSensor);
		m_animation.setDuration(Duration.seconds(8));
		m_animation.setFromX(initialPosition);
	}
}

























