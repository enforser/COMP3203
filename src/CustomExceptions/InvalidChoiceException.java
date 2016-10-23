// ======================================================================================
// FILE: InvalidChoiceException.java
// CREATION DATE: OCT 22, 2016
// ABOUT: A custom exception that is thrown when an invalid choice is encountered.
// ======================================================================================

package CustomExceptions;

public class InvalidChoiceException extends Exception 
{
	// ----------------------------------------------------------------------------------
	// Properties

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------------------
	// Constructor
	
	public InvalidChoiceException(
		String i_message
		)
	{
		super(i_message);
	}
}
