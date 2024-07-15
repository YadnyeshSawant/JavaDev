package practiceTest;
abstract  class Animal{
	abstract void eat();
	abstract void sleep();
}
class Lion extends Animal{
	void eat() {
		System.out.println("Lion is eating");
	}
	void sleep() {
		System.out.println("Lion is sleeping");
	}
}
class Tiger extends Animal{
	void eat() {
		System.out.println("Tiger is eating");
	}
	void sleep() {
		System.out.println("Tiger is sleeping");
	}
}
class Deer extends Animal{
	void eat() {
		System.out.println("Deer is eating");
	}
	void sleep() {
		System.out.println("Deer is sleeping");
	}
}
public class Question4 {

	public static void main(String[] args) {
		Animal animal;
		animal = new Lion();
		animal.eat();
		animal.sleep();
		
		animal = new Tiger();
		animal.eat();
		animal.sleep();
		
		animal = new Deer();
		animal.eat();
		animal.sleep();
	}
}
	
