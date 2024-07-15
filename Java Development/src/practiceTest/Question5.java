package practiceTest;

import java.util.Scanner;

abstract class GeometricShape{
	abstract void area();
	abstract void perimeter();
}
class Triangle extends GeometricShape{
	int height, base ,side1,side2,side3;
	void area() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Height and Base ");
		height = sc.nextInt();
		base = sc.nextInt();
		System.out.println("Area = "+ (0.5 * base * height));
	}
	void perimeter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter all three sides ");
		side1 = sc.nextInt();
		side2 = sc.nextInt();
		side3 = sc.nextInt();
		System.out.println("Perimeter = "+ (side1 + side2 + side3));
	}
}
class Square extends GeometricShape{
	int side;
	void area() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter side ");
		side = sc.nextInt();
		System.out.println("Area = "+ (side * side));
	}
	void perimeter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter all three sides ");
		side = sc.nextInt();
		System.out.println("Perimeter = "+ (side + side + side + side));
	}
}
public class Question5 {

	public static void main(String[] args) {
		GeometricShape g;
		g = new Triangle();
		g.area();
		g.perimeter();
		
		g =new  Square();
		g.area();
		g.perimeter();

	}

}
