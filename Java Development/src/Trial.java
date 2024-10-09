import java.util.Scanner;
import java.util.regex.*;  
public class Trial{  
public static void main(String args[]){  
//System.out.println("metacharacters d....");
//  
//System.out.println(Pattern.matches("\\d", "abc"));
//System.out.println(Pattern.matches("\\d", "1"));  
//System.out.println(Pattern.matches("\\d", "4443"));
//System.out.println(Pattern.matches("\\d", "323abc"));
//  
//System.out.println("metacharacters D....");
//  
//System.out.println(Pattern.matches("\\D", "abc")); 
//System.out.println(Pattern.matches("\\D", "1")); 
//System.out.println(Pattern.matches("\\D", "4443"));
//System.out.println(Pattern.matches("\\D", "323abc"));  
//System.out.println(Pattern.matches("\\D", "m")); 
//  
//System.out.println("meta characters D with quantifier....");  
//System.out.println(Pattern.matches("\\D*", "mak"));
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your name");
//	String input = sc.next();
	String name = null;
//	if(Pattern.matches("[a-zA-z]\\D+",input)) {
	if(Pattern.matches("^[a-zA-Z\\s]+$",sc.next())) {
		System.out.println("Data Saved Successfully");
		System.out.println("Name =" + name);
	}
	else {
		System.out.println("Wrong type of data");
	}
	
}
}