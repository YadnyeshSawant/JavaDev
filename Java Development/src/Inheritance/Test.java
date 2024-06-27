package Inheritance;
class Animal{
	void eat() {
		System.out.println("Eating");
	}
}
class Dog extends Animal{
	void bark() {
		System.out.println("Barking");
	}
}
public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.bark();
		d.eat();
	}

}
