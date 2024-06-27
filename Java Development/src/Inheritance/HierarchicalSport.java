package Inheritance;
import java.util.*;
class Student3{
	int rollno;
	String name;
	
}
class Marks3 extends Student3{
	String subject;
	float marks;
	Marks3(int rollno, String name, String subject,float marks){
		this.rollno = rollno;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}
	void displayMarks() {
		System.out.println("Rollno \t Name \t\t Subject \t Marks");
		System.out.println(rollno+"\t "+name+"\t "+subject+"\t\t "+marks);
	}
}
class Sport2 extends Student3{
	String sportName;
	int points;
	Sport2(int rollno,String name, String sportName, int points){
		this.rollno = rollno;
		this.name = name;
		this.sportName = sportName;
		this.points = points;
	}
	void displaySport() {
		System.out.println("Rollno \t Name \t\t Sport \t points");
		System.out.println(rollno+"\t "+name+"\t "+sportName+"\t "+points);
	}
}
public class HierarchicalSport {

	public static void main(String[] args) {
		Marks3 m1 = new Marks3(11,"Yadnyesh","Java", 10);
		Sport2 sport = new Sport2(11,"Yadnyesh","shooting",200);

//		System.out.println("Rollno \t Name \t\t Subject \t Marks \t Sport \t\t Points");
		int ch ;
		System.out.println("Enter Your Choice");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		if (ch==1) {
			m1.displayMarks();
		}
		else {
			sport.displaySport();
		}
	}

}
