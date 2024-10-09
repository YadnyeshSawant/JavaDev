package exceptionHandeling;
class Animal{
	void sound() {
		System.out.println("Makes sound");
	}
}
class Dog extends Animal{
	void sound() {
		System.out.println("Barks");
	}
}
public class CommonScenerios {

	public static void main(String[] args) {
		Animal a = (Animal) new Dog();
		a.sound();
	}
}