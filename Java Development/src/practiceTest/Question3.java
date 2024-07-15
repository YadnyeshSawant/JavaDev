package practiceTest;
class Shape{
	void getArea() {
		System.out.println("Print Area");
	}
}
class Rectangle extends Shape{
	double length,breadth;
	Rectangle(double length ,double breadth){
		this.length = length;
		this.breadth = breadth;
	}
	void getArea() {
		double area = length * breadth;
		System.out.println("Area = "+area);
	}
}
public class Question3 {

	public static void main(String[] args) {
		Shape r = new Rectangle(2,3);
		r.getArea();

	}

}
