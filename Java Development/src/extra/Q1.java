//Write a Java program to create an abstract class Animal with an abstract method called sound(). Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make a specific sound for each animal.

package extra;
abstract class Animal{
	abstract void sound();
}
class Lion extends Animal{

	@Override
	void sound() {
		System.out.println("Lion Roars");
		
	}

}
class Tiger extends Animal{
	@Override
	void sound() {
		System.out.println("Tiger Growls");
		
	}

}
public class Q1{
	public static void main(String[] args) {
		Animal animal;
		animal = new Lion();
		animal.sound();

		animal = new Tiger();
		animal.sound();

	}
}
	
