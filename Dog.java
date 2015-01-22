package dogOwner;

//Dog superclass for Breed, uses superclass Mammal
public class Dog extends Mammal {
	protected int hunger;
	protected int fun;
	protected int cleanliness;
	protected int loyalty;
	protected int obesity;
	
	//sets the Mammal super class requirement in the constructor
	public Dog(String f){
		super(f);
	}

	//sets the hunger, fun, cleanliness, and obesity (used here based on selected breed)
	public void setStats(int a, int b, int c, int e){
		hunger = a;
		fun = b;
		cleanliness = c;
		obesity = e;
	}	
}