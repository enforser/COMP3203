// ======================================================================================
// FILE: NumberRounder.java
// CREATION DATE: DEC 3, 2016
// ABOUT: Responsible for rounding numbers.
// ======================================================================================

package utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberRounder
{
	// ----------------------------------------------------------------------------------
	// Methods
	
	public double roundDouble(
		double i_double
		)
	{		
		BigDecimal bigDecimal = new BigDecimal(i_double);
		bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
		
		double roundedDouble = bigDecimal.doubleValue();
				
		return roundedDouble;
	}
}
