package FinalKeyword;

public class Cube {
	int cube(final int n) {
		return n * n * n;
	}
	public static void main(String[] args) {
		Cube c = new Cube();
		System.out.println(c.cube(2));
	}
}
