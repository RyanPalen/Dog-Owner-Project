package dogOwner;


import java.util.Scanner;

//Human class with Mammal as Super class
public class Human extends Mammal {

	private int money, choiceInt, dogCount, dogTotal;
	private int dogfood, hour, extHour, dogRunningCount;
	private Breed dogList[];
	private String dogName;
	private String choice;
	
	//integer array to store the actions over the allotted hours in the day
	private int[] actions = new int[6];
	
	//the object which runs the different actions
	private ActionChoice achoice;
	
	//the object which checks and converts 0-9 digits from strings
	private NumCheck numCheck;
	
	//the flag that the day has been spent
	private boolean dayDone;

	//Constructor requiring the dog count and the weight, sex, and name for the super class
	public Human(int c, String d, int e, String f){
		super(d, e, f);
		money = 100;
		dogfood = 10;
		dogCount = c;
		dogTotal = c;
		dogRunningCount = c;
		hour = 0;
		achoice = new ActionChoice();
		dayDone = false;
	}

	//gets the running count of living dogs for the human object
	public int getDogsLeft(){
		//resets the counter
		dogRunningCount = dogCount;
		
		for (int i = 0; i < dogCount; i++){
			
			//checks to see if each dog is living
			if (!dogList[i].getExist()){
				
				//subtracts 1 for each dog that doesn't exist
				dogRunningCount--;
			}
		}
		
		//returns the number of living dogs
		return dogRunningCount;
	}
	
	//sets the done flag to signal end of the day
	public void setDone(boolean a){
		dayDone = a;
	}
	
	//gets the done status
	public boolean getDone(){
		return dayDone;
	}
	
	//makes the dog objects
	public void makeDog(Scanner input){
		dogList = new Breed[dogTotal];
		
		//for loop which asks the name of each dog and sets the breed using the setBreed method
		for (int i = 0; i < dogTotal; i++){
			System.out.print("Please name dog number " + (i+1) + ": ");
			dogName = input.next();
			dogList[i] = new Breed(dogName);
			dogList[i].setBreed();
			System.out.println(dogList[i].getBreed());
		}
	}
	
	//runs the choice, uses the scanner to determine how many cans of food to buy
	public void humanChoice(int a, Scanner b){
		
		//if there are not enough hours in the day, error
		if (hour > 13){
			System.out.println("Sorry, this person is out of time for the day. Please make another choice");
		}
		
		//Walk Dog
		else if (a == 1){
			if (hour > 12){
				System.out.println("There isn't enough time left in the day for that. Please make another choice");
			}
			else{
				
				//increases the amount of time that has been spent by 2 hours
				hour += 2;
				
				//adds to the walk counter at actions[0]
				actions[0]++;
			}
		}
		
		//Feed Dog
		else if (a == 2){
			if (hour > 13){
				System.out.println("There isn't enough time left in the day for that. Please make another choice");
			}
			else{
				
				//check the number of cans left
				if (dogfood >= getDogsLeft()){
					
					//subtract the number of cans based on the number of dogs
					dogfood -= getDogsLeft();
					hour += 1;
					actions[1]++;
				}
				else{
					System.out.println("Not enough dog food to cover this, cans available: " + dogfood);
				}
			}
		}
		
		//Bathe Dog
		else if (a == 3){
			if (hour > 12){
				System.out.println("There isn't enough time left in the day for that. Please make another choice");
			}
			else {
				hour += 2;
				actions[2]++;
			}
		}
		
		//Go to Work
		else if (a == 4){
			if (hour > 8){
				System.out.println("There isn't enough time left in the day for that. Please make another choice");
			}
			else {
				
				//increase amount of money
				money += 50;
				hour += 6;
				actions[3]++;
			}
		}
		
		//Buy Dogfood
		else if (a == 5){
			if (hour > 13){
				System.out.println("There isn't enough time left in the day for that. Please make another choice");
			}
			else {
				System.out.print("How many cans? (0-9) ");
				choice = b.next();
				numCheck = new NumCheck(choice);
				choiceInt = numCheck.convertNum();
				
				//check to make sure there is enough money at 10 a can of food (inflation?)
				if (money < (choiceInt * 10)){
					System.out.println("Credit Card Declined! Work more to get money.");
				}
				else{
					//increase the number of cans based on the choice
					dogfood += choiceInt;
					
					//subtract money based on the number of cans
					money -= (10*choiceInt);
				}
				hour += 1;
				actions[4]++;
			}
		}
		
		//Pass the Time
		else if (a == 6){
			
			//gets the number of hours remaining
			extHour = 14 - hour;
			
			//maxes out the hours
			hour = 14;
			dayDone = true;
			actions[5] = 1;
		}
		if (hour > 13){
			
			//sets the done flag to true
			setDone(true);
		}
	}

	//runs the actions chosen in the humanChoice method
	public void runActions(){
		//dog loop
		for (int i = 0; i < dogCount; i++){
			//choice loop
			for (int j = 0; j < 6; j++){
				//iteration loop based on number of queued actions
				for (int k = 0; k < actions[j]; k++){
					
					//statement chooses to run the associated method with the action[j] entry
					switch (j){
					case 0:
						achoice.walkDog(dogList[i]);
						break;
					case 1:
						achoice.feedDog(dogList[i]);
						break;
					case 2:
						achoice.batheDog(dogList[i]);
						break;
					case 3:
						achoice.workDog(dogList[i]);
						break;
					case 4:
						achoice.buyDogFood(dogList[i]);
						break;
					case 5:
						
						//passes the remaining hours for determining change in fun and hunger
						extHour = 14-hour;
						dayDone = true;
						achoice.passTimeDog(dogList[i], extHour);
						break;
					}
				}
			}
			//reset the obesity counter for the next day
			dogList[i].resetObeseCount(0);
		}
		
		//sets the loyalty
		for (int i = 0; i < dogCount; i++){
			dogList[i].setLoyalty();
			
			//resets the actions to 0 accross the board
			for (int j = 0; j < 6; j++){
				actions[j] = 0;
			}
		}
		//resets the hour and the day done flag
		dayDone = false;
		hour = 0;
	}
	
	//sets all of the people to done based on the overall menu instead of the individual menu
	public void setAllDone(){
		for (int i = 0; i < dogCount; i++){
			extHour = 14 - hour;
			dayDone = true;
			actions[5] = 1;
		}
	}
	
	//returns the string containing the pertinent Human statistics (I omitted weight as I felt it was unneeded).
	public String toString(){
		return "Name: " + name + "\nMoney: $" + money + "\nAmount of Dogfood: " + dogfood + " cans\nHours Left: " + (14 - hour) + " hours\n";
	}
	
	//prints out the dog's toString method
	public void dogToString(){
		
		//for loop iterates the call for each dog
		for (int i = 0; i < dogCount; i++){
			System.out.println(dogList[i].toString());
		}
	}
}