// ======================================================================================
// FILE: InvalidInputException.java
// CREATION DATE: OCT 20, 2016
// ABOUT: Responsible for verifying user input from the GUI
// ======================================================================================

package CustomExceptions;

public class InvalidInputException extends Exception
{

	private static final long serialVersionUID = 1L;

	public InvalidInputException()
	{
		super("Input was invalid");
	}
	
	public InvalidInputException(
		String i_message
		)
	{
		super(i_message);
	}
	
	
}
