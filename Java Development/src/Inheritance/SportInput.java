package Inheritance;
import java.util.*;
class Student2{
	int rollno;
	String name;
}
class Marks2 extends Student2{
	String subject;
	float marks;
}
class Sport1 extends Marks2{
	String sportName;
	int points;
	
	Sport1(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Rollno");
		rollno = sc.nextInt();
		System.out.println("Enter Name");
		name = sc.next();
		System.out.println("Enter Subject Name");
		subject = sc.next();
		System.out.println("Enter Marks");
		marks = sc.nextFloat();
		System.out.println("Enter Sport Name");
		sportName = sc.next();
		System.out.println("Enter Points");
		points = sc.nextInt();
		
	}
	void displayDetails() {
		System.out.println(rollno+"\t "+name+"\t "+subject+"\t\t "+marks+"\t "+sportName+"\t "+points);
	}
}
public class SportInput {
	public static void main(String args[]) {
		Sport1 sport = new Sport1();
		System.out.println("Rollno \t Name \t\t Subject \t Marks \t Sport \t\t Points");
		sport.displayDetails();
		
	}
}
