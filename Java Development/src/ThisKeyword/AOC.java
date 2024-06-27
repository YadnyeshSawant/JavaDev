package ThisKeyword;
class area{
	double radius;
	static double pi = 3.14;
	double area;
	
	area(double radius){
		this.radius = radius;
		area = pi*radius*radius;
		System.out.println(area);
	}
}
public class AOC {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		area a1 = new area(12);
	}

}
