package dogOwner;

import java.util.Random;

public class Breed extends Dog {
	private int selection;
	private String breed;
	private boolean exist;
	private int obeseCount;
	
	//constructor takes in the name for the second super class constructor
	public Breed(String b){
		super(b);
		
		//sets a random breed numerical value, set below
		Random randBreed = new Random();
		selection = randBreed.nextInt((4 - 1) +1) +1;
		
		//sets exist to true
		exist = true;
		
		//sets obese over feed counter to 0
		obeseCount = 0;
	}

	//Sets the breed based on the random number in the constructor
	public void setBreed(){
		switch (selection){
			case 1:
				//each breed sets specific starting stats to that breed
				breed = "Golden Retriever";
				setStats(10,80,80,0);
				//runs the setLoyalty method to set the loyalty
				setLoyalty();
				break;
			case 2:
				breed = "Papillon";
				setStats(10,90,85,0);
				setLoyalty();
				break;
			case 3:
				breed = "Bulldog";
				setStats(20,80,80,2);
				setLoyalty();
				break;
			case 4:
				breed = "Chihuahua";
				setStats(20,85,90,5);
				setLoyalty();
				break;
		}
	}

	//returns the breed
	public String getBreed(){
		return breed;
	}

	//returns true or false based on the exist variable
	public boolean getExist(){
		return exist;
	}
	
	//sets the obese counter
	public void setObeseCount(int a){
		obeseCount += a;
	}

	//resets the obese counter to a (used to reset to 0)
	public void resetObeseCount(int a) {
		obeseCount = a;
	}
	
	//returns the obese counter
	public int getObeseCount(){
		return obeseCount;
	}
	
	//sets the hunger stat
	public void setHunger(int a){
		hunger += a;
		if (hunger > 100){
			hunger = 100;
		}
		else if (hunger < 0){
			hunger = 0;
		}
	}
	
	//returns the hunger stat
	public int getHunger(){
		return hunger;
	}
	
	//sets the fun stat
	public void setFun(int a){
		fun += a;
		if (fun > 100){
			fun = 100;
		}
		else if (fun < 0){
			fun = 0;
		}
	}
	
	//returns the fun stat
	public int getFun(){
		return fun;
	}
	
	//sets the cleanliness stat
	public void setClean(int a){
		cleanliness += a;
		if (cleanliness > 100){
			cleanliness = 100;
		}
		else if (cleanliness < 0){
			cleanliness = 0;
		}
	}
	
	//returns the cleanliness stat
	public int getClean(){
		return cleanliness;
	}
	
	//sets obesity
	public void setObesity(int a){
		obesity += a;
		if (obesity > 20){
			obesity = 20;
		}
		else if (obesity < 0){
			obesity = 0;
		}
	}
	
	//returns obesity
	public int getObesity(){
		return obesity;
	}
	
	//sets loyalty based on whether or not the dog is dead
	public void setLoyalty(){
		if (exist){
			loyalty = Math.min(fun, (100-hunger));
		}
		else if (!exist){
			loyalty = 0;
		}
	}
	
	//returns loyalty
	public int getLoyalthy(){
		return loyalty;
	}
	
	//checks if the dog has fallen prey to starvation, obesity, mange, or disloyalty
	public boolean checkLife(){
		if (hunger > 90){
			System.out.println("Your dog has starved to death. You should be ashamed!");
			name = "DEAD";
			return false;
		}
		else if (obesity > 17){
			System.out.println("Your dog has been fed too much and died. You should be more careful");
			name = "DEAD";
			return false;
		}
		else if (loyalty < 15){
			System.out.println("Your dog doesn't like you much. He decided to make it in this world without you");
			name = "RUNAWAY";
			return false;
		}
		else if (cleanliness < 15){
			System.out.println("Your dog has mange and is taken by the ASPCA for his protection.");
			name = "MANGE";
			return false;
		}
		else{
			return true;
		}
	}
	
	//sets the dog to dead, essentially
	public void setGoneDog(){
		setStats(0,0,0,0);
		exist = false;
	}
	
	//the dog's toString function
	public String toString(){
		return "Dog name: " + name + "\nBreed: " + breed + " \nFun: " + fun + "\nLoyalty: " + loyalty + "\nHunger: " + hunger + "\nCleanliness: " + cleanliness + "\nObesity: " + obesity + "\n\n";
	}


}