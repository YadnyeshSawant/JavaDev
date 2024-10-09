package regex;
import java.util.Scanner;
import java.util.regex.*;
public class Regex {
	public static void main(String[] args) {
	// ways to write the regex example
		Pattern p = Pattern.compile(".s");
		Matcher m = p.matcher("as");
		boolean b = m.matches();
		System.out.println(b);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String input = sc.next();
		String name = null;
   // if(Pattern.matches("[a-zA-z]\\D+",input)) {
		if(Pattern.matches("^[a-zA-Z\\s]+$",input)) {
			name = input;
			System.out.println("Data Saved Successfully");
			System.out.println("Name =" + name);
		}
		else {
			System.out.println("Wrong type of data");
		}
	}
}
