package dogOwner;

import java.util.Random;

//Mammal Super Class
public class Mammal {
	protected String name;
	private int weight;
	protected String sex;
	
	//Constructor requiring name, weight, and sex
	//Used for humans
	public Mammal(String a, int b, String c){
		name = a;
		weight = b;
		sex = c;
	}
	
	//constructor requiring name, ignoring weight, and assigning sex randomly
	//Used for dogs
	public Mammal(String a){
		
		//I felt it would be too repetitive to require the weight
		//for each dog
		name = a;
		
		//randomly assigns the sex
		Random randSex = new Random();
		int b = randSex.nextInt((2 - 1) +1) +1;
		if (b == 1){
			sex = "Male";
		}
		else{
			sex = "Female";
		}
	}
	
	//returns the name attribute
	public String getName(){
		return name;
	}
}