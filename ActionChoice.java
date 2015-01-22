package dogOwner;

public class ActionChoice {
	
	//This class is to do the different actions
	
	//Feed Dog action, takes in the breed array
	public void feedDog(Breed a){
		//Make sure the dog exists
		if (a.getExist()){
			//standard if statement based on breed
			if (a.getBreed() == "Golden Retriever"){
				//set the different stats associated with action
				a.setHunger(-8);
				a.setObeseCount(1);
				
				//this is my obesity counter. If you feed the dog
				//more than 3 times a day, the obesity goes up
				if (a.getObeseCount() >3){
					a.setObesity(1);
				}
			}
			
			//These are all the same but with different values
			else if (a.getBreed() == "Papillon"){
				a.setHunger(-10);
				a.setObeseCount(1);
				if (a.getObeseCount() >3){
					a.setObesity(2);
				}
			}
			else if (a.getBreed() == "Bulldog"){
				a.setHunger(-5);
				a.setObeseCount(1);
				if (a.getObeseCount() >3){
					a.setObesity(4);
				}
			}
			else if (a.getBreed() == "Chihuahua"){
				a.setHunger(-10);
				a.setObeseCount(1);
				if (a.getObeseCount() >3){
					a.setObesity(4);
				}
			}
		}
		
		//Checks if the dog still exists and then checks its life
		//if the life check comes back false, sets the dog dead
		if (a.getExist()){
			if (!a.checkLife()){
				a.setGoneDog();
			}
		}
	}
	
	//Bathe the dog action
	//works the exact same as Feed Dog
	public void batheDog(Breed a){
		if (a.getExist()){
			if (a.getBreed() == "Golden Retriever"){
				a.setFun(-5);
				a.setClean(5);
				a.setHunger(5);
			}
			else if (a.getBreed() == "Papillon"){
				a.setFun(-9);
				a.setClean(5);
				a.setHunger(3);
			}
			else if (a.getBreed() == "Bulldog"){
				a.setFun(-4);
				a.setClean(5);
				a.setHunger(6);
			}
			else if (a.getBreed() == "Chihuahua"){
				a.setFun(-8);
				a.setClean(5);
				a.setHunger(7);
			}
		}
		if (a.getExist()){
			if (!a.checkLife()){
				a.setGoneDog();
			}
		}
	}
	
	//Buy dogfood action
	//works the exact same as Feed Dog
	public void buyDogFood(Breed a){
		if (a.getExist()){
			if (a.getBreed() == "Golden Retriever"){
				a.setFun(-4);
			}
			else if (a.getBreed() == "Papillon"){
				a.setFun(-4);
			}
			else if (a.getBreed() == "Bulldog"){
				a.setFun(-2);
			}
			else if (a.getBreed() == "Chihuahua"){
				a.setFun(-2);
			}
		}
		if (a.getExist()){
			if (!a.checkLife()){
				a.setGoneDog();
			}
		}
	}
	
	//Pass the time action. Takes in the time remaining in the day.
	public void passTimeDog(Breed a, int c){
		if (a.getExist()){
			if (a.getBreed() == "Golden Retriever"){
				
				//lowers fun by twice the hours remaining in the day
				a.setFun(-c*2);
				a.setHunger(c);
			}
			else if (a.getBreed() == "Papillon"){
				a.setFun(-c*2);
				a.setHunger(c);
			}
			else if (a.getBreed() == "Bulldog"){
				a.setFun(-c*2);
				a.setHunger(c);
			}
			else if (a.getBreed() == "Chihuahua"){
				a.setFun(-c*2);
				a.setHunger(c);
			}
		}
		if (a.getExist()){
			if (!a.checkLife()){
				a.setGoneDog();
			}
		}
	}
	
	//Go to work action
	//Works the exact same as Feed Dog
	public void workDog(Breed a){
		if (a.getExist()){
			if (a.getBreed() == "Golden Retriever"){
				a.setFun(-8);
				a.setHunger(5);
			}
			else if (a.getBreed() == "Papillon"){
				a.setFun(-7);
				a.setHunger(7);
			}
			else if (a.getBreed() == "Bulldog"){
				a.setFun(-3);
				a.setHunger(6);
			}
			else if (a.getBreed() == "Chihuahua"){
				a.setFun(-3);
				a.setHunger(8);
			}
		}
		if (a.getExist()){
			if (!a.checkLife()){
				a.setGoneDog();
			}
		}
	}
	
	//Walk the dog action
	//works the exact same as Feed Dog
	public void walkDog(Breed a){
		if (a.getExist()){			
			if (a.getBreed() == "Golden Retriever"){
				a.setFun(4);
				a.setClean(-12);
				a.setHunger(1);
			}
			else if (a.getBreed() == "Papillon"){
				a.setFun(4);
				a.setClean(-10);
				a.setHunger(2);
			}
			else if (a.getBreed() == "Bulldog"){
				a.setFun(6);
				a.setClean(-8);
				a.setHunger(1);
			}
			else if (a.getBreed() == "Chihuahua"){
				a.setFun(3);
				a.setClean(-8);
				a.setHunger(2);
			}
			if (a.getExist()){
				if (!a.checkLife()){
					a.setGoneDog();
				}
			}
		}
	}
}