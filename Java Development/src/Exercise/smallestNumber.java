//Write a Java method to find the smallest number among three numbers.
package Exercise;
import java.util.*;
public class smallestNumber {

	public static void main(String[] args) {
		int a,b,c;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		int small = ((a<b) && (a<c)?a:(b<a) && (b<c)?b:c);
		
		System.out.println("Smallest number is "+ small);
	}

}
