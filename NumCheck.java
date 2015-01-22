package dogOwner;

import java.util.InputMismatchException;
import java.util.Scanner;

//my workaround class for time to convert digits in string to int 
public class NumCheck {
	private String inputString;
	private int inputInt;
	
	//constructor takes in the string
	public NumCheck(String a){
		inputString = a;
	}
	
	//constructor which takes in integer for the try/catch
	public NumCheck(int a){
		inputInt = a;
	}
	
	//uses a switch to convert the string to a digit (default to -1 for error check)
	public int convertNum(){
		switch (inputString){
		case "1":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "0":
			return 0;
		default:
			return -1;
		}
	}
	
	//finally got my try catch running and used it once in the main (notated there)
	public boolean tryCatch(Scanner a){
		
		//tries for an integer
		try{
			inputInt = a.nextInt();
			
		//catches the input mismatch exception and assigns -1
		}catch(InputMismatchException e){
			inputInt = -1;
		}
		if (inputInt == -1){
			
			//error output with false return
			System.out.println("Invalid Input\n");
			return false;
		}
		//true return
		return true;
	}
}