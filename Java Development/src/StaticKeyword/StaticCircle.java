package StaticKeyword;
import java.util.*;
class AreaOfCircle
{
	int radius;
	static double pi = 3.14;
	
	AreaOfCircle()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Radius");
		radius = sc.nextInt();
		double AOC = pi*radius*radius;
		System.out.println("Area of Circle = "+AOC);
	}
}
public class StaticCircle {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AreaOfCircle c1 = new AreaOfCircle();
	}

}
