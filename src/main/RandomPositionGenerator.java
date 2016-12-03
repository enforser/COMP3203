// ======================================================================================
// FILE: RandomPositionGenerator.java
// CREATION DATE: DEC 3, 2016
// ABOUT: Responsible for generating a random number between 0 and 1 as the initial 
//        center point for each new sensor. 
// ======================================================================================
package main;

import java.util.Random;
import utilities.NumberRounder;

public class RandomPositionGenerator
{
	// ----------------------------------------------------------------------------------
	// Properties
	
	private Random m_random;
	private NumberRounder m_numberRounder;
	
	// ----------------------------------------------------------------------------------
	// Constructor
	
	RandomPositionGenerator()
	{
		m_random = new Random();
		m_numberRounder = new NumberRounder();
	}
	
	// ----------------------------------------------------------------------------------
	// Methods
	
	public Double generateRandomPosition()
	{	
		Double randomPosition;
		
		randomPosition = m_random.nextDouble();
		randomPosition = m_numberRounder.roundDouble(randomPosition);
		
		return randomPosition;
	}
}
