//Write a Java program to create a class called Shape with a method called getArea(). Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.
package Polymorphism;
class Shape{
	void getArea() {
		System.out.println("Prints the area of the shape");
	}
}
class Rectangle extends Shape{
	int length,breadth;
	Rectangle(int length, int breadth){
		this.length = length;
		this.breadth = breadth;
	}
	void getArea() {
		System.out.println(length * breadth);
	}
}
public class AreaCal {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(2,4);
		r.getArea();

	}

}
