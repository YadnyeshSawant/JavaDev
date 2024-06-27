//Write a Java method to compute the average of three numbers.
package Exercise;
import java.util.*;
class Avg{
	int a,b,c;
	float avg;
	Avg(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		this.a = sc.nextInt();
		this.b = sc.nextInt();
		this.c = sc.nextInt();
		this.avg = ((a+b+c)/3);
		System.out.println("The average is "+ avg);
	} 
}
public class average {
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Avg A = new Avg();

	}
}
