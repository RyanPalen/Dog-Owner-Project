package dogOwner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//long list of variables
		int pWeight = 0, doneCount = 0, deadDogCount = 0, humanCount = 0;
		int pDogs = 0, count = 0, quit = 0, pass = 0, choiceInt = 0, humanChoice = 0;
		String pSex = new String();
		String pSexFin = new String();
		String choice = new String();
		String pName = new String();
		boolean sexTrue = false;
		Scanner keyInput = new Scanner(System.in);
		NumCheck inNum;
		
		//while to check that the count is within 0-5, quitting on 0, retrying on anything else
		boolean countWithin = false;
		while (!countWithin){
			System.out.println("How many people? (5 max)");
			choice = keyInput.next();
			
			//uses my NumCheck class to convert to digit
			inNum = new NumCheck(choice);
			humanCount = inNum.convertNum();
			
			//on anything not 0-5 (including my -1 error check), invalid selection error
			if (humanCount < 0 || humanCount > 5){
				System.out.println("Invalid Selection, please input integer 0-5.\n");
			}
			
			//if 0, no humans, quit program. I close input streams before each exit
			else if(humanCount == 0){
				System.out.println("No Humans to make, goodbye!");
				keyInput.close();
				System.exit(0);
			}
			else{
				countWithin = true;
				continue;
			}
		}
		//destroys the inNum object
		inNum = null;
		
		//creates the Human object array
		Human[] humanList = new Human[humanCount];
		
		//runs the required stat questions for each entry in the Human array
		for (int i = 0; i < humanCount; i++){
			sexTrue = false;
			pWeight = 0;
			pDogs = 0;
			
			System.out.print("Please name person number " + (i+1) + ": ");
			pName = keyInput.next();
			
			boolean weightTrue = false;
			
			//I was having issues with Try Catch. This was my
			//final solution but I didn't have time to recode the
			//previous problem areas so I just added the tryCatch()
			//method to the work around NumCheck class
			do{
			System.out.print("Weight: ");
			
			//this was my issue, destroying the keyInput object and recreating
			//it solved my problem where the stream didn't clear properly. Probably
			//not the most efficient, but it works
			keyInput = null;
			keyInput = new Scanner(System.in);
			
			inNum = new NumCheck(pWeight);
			weightTrue = inNum.tryCatch(keyInput);
			}while (!weightTrue);
			
			//check for valid input on sex question. Will take 1, 2, m, f, or male, female
			//could have used a string comparison to allow other options, but I thought this was sufficient
			while (!sexTrue){
				System.out.print("Sex:  1. Male\n      2. Female\n");
				
				//puts everything to lowercase
				pSex = keyInput.next().toLowerCase();
						
				//switch statement assigns the string "Male" or "Female" depending on the case
				switch (pSex){
					case "1":
						pSexFin = "Male";
						sexTrue = true;
						break;
					case "m":
						pSexFin = "Male";
						sexTrue = true;
						break;
					case "male":
						pSexFin = "Male";
						sexTrue = true;
						break;
					case "2":
						pSexFin = "Female";
						sexTrue = true;
						break;
					case "f":
						pSexFin = "Female";
						sexTrue = true;
						break;
					case "female":
						pSexFin = "Female";
						sexTrue = true;
						break;
					default:
						System.out.println("Invalid option, please choose 1 or 2\n");
						break;
				}
			}
			
			//checks for valid input on number of dogs
			boolean validInput = false;
			while (!validInput){
				System.out.print("Number of Dogs (4 max): ");
				
				//same as above with humanCount
				choice = keyInput.next();
				inNum = new NumCheck(choice);
				pDogs = inNum.convertNum();
				inNum = null;
				
				if (pDogs < 1 || pDogs > 4)
					System.out.println("Invalid choice, please input an integer 1-4");
				else
					validInput = true;
			}
			
			//creates the human and runs the makeDog method, then repeats the for loop
			humanList[i] = new Human(pDogs, pName, pWeight, pSexFin);
			humanList[i].makeDog(keyInput);
		}
		
		//calls the human and dog toString functions
		for (int i = 0; i < humanCount; i++){
			System.out.println(humanList[i].toString());
			humanList[i].dogToString();
		}
		
		//Run Program Loop!!!
		boolean runProgram = true;
		while (runProgram){
			
			boolean passTheTime = false;
			System.out.println("Which person would you like to set?");
			
			//menu listing the options
			for (int i = 0; i < humanCount; i++){
				System.out.println((i + 1) + " " + humanList[i]);
				count = i;
			}
			
			//menu options for pass the time and for quitting the program
			System.out.println((humanCount + 1) + ". Pass Time");
			System.out.println((humanCount + 2) + ". Quit Program");
			
			//sets the value to pass and quit based on the menu print out
			pass = humanCount + 1;
			quit = humanCount + 2;
			
			//switch statement to check a confined choice pool
			boolean validChoice = false;
			while (!validChoice){
				System.out.print("Choice: ");
				choice = keyInput.next();
				
				switch (choice){
					case "1":
						//makes humanChoice = 0 and sets validChoice to true
						if (1 <= (count + 1)){
							humanChoice = 0;
							validChoice = true;
							break;
						}
					case "2":
						if (2 <= (count + 1)){
							humanChoice = 1;
							validChoice = true;
							break;
						}
						//checks to see if pass the time was option 2
						else if (2 == pass){
							passTheTime = true;
							validChoice = true;
							
							//sets done for all the humans in the array
							for (int i = 0; i < humanCount; i++){
								humanList[i].setDone(true);
							}
							break;
						}
					case "3":
						if (3 <= (count + 1)){
							humanChoice = 2;
							validChoice = true;
							break;
						}
						
						//3 is the first option with the quit option possible (1 human, 2 pass, 3 quit)
						else if (3 == quit){
							System.out.println("Goodbye!");
							keyInput.close();
							System.exit(0);
						}
						else if (3 == pass){
							passTheTime = true;
							validChoice = true;
							for (int i = 0; i < humanCount; i++){
								humanList[i].setDone(true);
							}
							break;
						}
					case "4":
						if (4 <= (count + 1)){
							humanChoice = 3;
							validChoice = true;
							break;
						}
						else if (4 == quit){
							System.out.println("Goodbye!");
							keyInput.close();
							System.exit(0);
						}
						else if (4 == pass){
							passTheTime = true;
							validChoice = true;
							for (int i = 0; i < humanCount; i++){
								humanList[i].setDone(true);
							}
							break;
						}
						//first possible invalid selection
						else{
							System.out.println("Invalid Selection");
							break;
						}
					case "5":
						if (5 <= (count + 1)){
							humanChoice = 4;
							validChoice = true;
							break;
						}
						else if (5 == quit){
							System.out.println("Goodbye!");
							keyInput.close();
							System.exit(0);
						}
						else if (5 == pass){
							passTheTime = true;
							validChoice = true;
							for (int i = 0; i < humanCount; i++){
								humanList[i].setDone(true);
							}
							break;
						}
						else{
							System.out.println("Invalid Selection");
							break;
						}
					//6 cannot be a legitimate option except quit or pass
					case "6":
						if (6 == quit){
							System.out.println("Goodbye!");
							keyInput.close();
							System.exit(0);
						}
						else if (6 == pass){
							passTheTime = true;
							validChoice = true;
							for (int i = 0; i < humanCount; i++){
								humanList[i].setDone(true);
							}
							break;
						}
						else{
							System.out.println("Invalid Selection");
							break;
						}
					//7 cannot be a legitimate option except for quit
					case "7":
						if (7 == quit){
							System.out.println("Goodbye!");
							keyInput.close();
							System.exit(0);
						}
						else{
							System.out.println("Invalid Selection");
							break;
						}
					default:
						System.out.println("Invalid Selection");
						break;
				}
			}
			
			//if pass the time is still false, run the menu
			if (!passTheTime){
				validChoice = false;
				
				//input validation
				while(!validChoice){
					
					//checks to see if the human chosen has no living dogs and reminds them of that fact... tisk...
					if (humanList[humanChoice].getDogsLeft() < 1){
						System.out.println(humanList[humanChoice].getName() + " does not have any living dogs. Please choose again.");
						validChoice = true;
					}
					
					//prints the menu and takes the input
					else{
						System.out.println("You have chosen: " + humanList[humanChoice].getName());
						System.out.println("What would you like to do?\n1. Walk the Dogs?\n2. Feed the Dogs?\n3. Bathe the Dogs?\n4. Go to Work?\n5. Buy more Dog Food?\n6. Pass the Time (Spend Remaining Hours)?");
					
						System.out.println("7. Quit");
						choice = keyInput.next();
			
						//same as before using my NumCheck class
						inNum = new NumCheck(choice);
						choiceInt = inNum.convertNum();
				
						if (choiceInt < 0 || choiceInt > 7){
							System.out.println("Invalid Selection. Please choose again.");
						}
						else if (choiceInt == 7){
							keyInput.close();
							System.exit(0);
						}
						else{
							validChoice = true;
						}
						//runs the humanChoice method passing the choice and the Scanner object for input
						humanList[humanChoice].humanChoice(choiceInt, keyInput);
					}
				}
			}
			
			//if pass the time is set to true, set it true for all humans and that humans
			else if (passTheTime){
				for (int i = 0; i < humanCount; i++){
					//somewhat redundant but it works so I don't want to break it
					humanList[i].setDone(true);
					humanList[i].setAllDone();
				}
			}
			
			//checks to see if all the humans are individually done
			for (int i = 0; i < humanCount; i++){
				if (!humanList[i].getDone()){
					doneCount--;
				}
				else{
					doneCount++;
					
					//if doneCount ends up equalling the number of humans, run the actions
					if (doneCount == humanCount){
						for (int j = 0; j < humanCount; j++){
							
							//uses the runActions method to do all of the actions accumilated in the day
							humanList[j].runActions();
							
							//outputs the toString methods of the humans and their dogs
							System.out.println(humanList[j].toString());
							humanList[j].dogToString();
							
							//resets the done counter
							doneCount = 0;
						}
					}
				}
			}
			//resets the done Counter
			doneCount = 0;
			
			//checks to see if all the dogs are dead
			for (int i = 0; i < humanCount; i++){
				
				//checks to see if getDogsLeft returns less than 1
				if (humanList[i].getDogsLeft() < 1){
					
					//increases the dead dog counter
					deadDogCount++;
					
					//if all of the dogs are dead for all of the humans, prints a goodbye message and exits
					if (deadDogCount == humanCount){
						System.out.println("You have no more dogs... Goodbye!");
						keyInput.close();
						System.exit(0);
					}
				}
			}
			//reset dead dog counter
			deadDogCount = 0;
		}
		//just in case
		keyInput.close();
	}
}