package FinalKeyword;
class Bike1{
	final void run1() {
		System.out.println("Running.....");
	}
}
public class Honda extends Bike1 {
	public static void main(String[] args) {
		Bike1 b = new Bike1();
		b.run1();

	}

}
