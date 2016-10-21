// ======================================================================================
// FILE: InputVerifier.java
// CREATION DATE: OCT 20, 2016
// ABOUT: Responsible for verifying user input from the GUI
// ======================================================================================

package main;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class InputVerifier 
{
	// ----------------------------------------------------------------------------------
	// Methods
	
	public boolean isInt(
		TextField i_textField,
		String i_inputValue
		)
	{
		try
		{
			int value = Integer.parseInt(i_inputValue);
			
			System.out.println("-- " + value + " sensors");
			
			return true;
		} 
		catch(NumberFormatException e) 
		{
			System.out.println("-- Input was not valid");
			
			showInvalidSensorInputAlert();
			
			return false;
		}
	}
	
	private void showInvalidSensorInputAlert()
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Input");
		alert.setHeaderText("Invalid Input");
		alert.setContentText("Number of sensors must be an integer.");
		alert.showAndWait();
	}
}
