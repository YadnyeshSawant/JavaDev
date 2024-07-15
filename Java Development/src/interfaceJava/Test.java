package interfaceJava;
interface Drawable{
	void draw();
}
class Rectangle implements Drawable{
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}
class Circle implements Drawable{
	public void draw() {
		System.out.println("Drawing Circle");
	}
}
public class Test {

	public static void main(String[] args) {
		Drawable d  = new Rectangle();
		d.draw();

	}

}
