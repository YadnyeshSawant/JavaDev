//print a custom message on exception.
package exceptionHandeling;

public class CustomMessage {

	public static void main(String[] args) {
		int i =10;
		int j=0;
		int b;
		try {
			int a = 50/0;
		}
		catch(ArithmeticException e){
			System.out.println(e);
			System.out.println("Cannot devide by 0");
		}
		try {
			b = i/j;
		}
		catch(ArithmeticException r) {
			b = i/(+2);
			System.out.println(r);
			System.out.println("cannot d by 0");
		}
	}

}
