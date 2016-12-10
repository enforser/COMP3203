// ======================================================================================
// FILE: ToolBelt
// CREATION DATE: DEC 10, 2016
// ABOUT: General utilities class
// ======================================================================================

package utilities;

// ======================================================================================
// CLASS

public class ToolBelt
{
	// ----------------------------------------------------------------------------------
	// Methods
	
	public double calculateScaledPosition(
		double i_position
		)
	{
		return i_position * Constants.SCALE_BY;
	}
	
	
	
	public double calculateScaledRadius(
		double i_radius
		)
	{
		return i_radius * Constants.SCALE_BY;
	}
}
