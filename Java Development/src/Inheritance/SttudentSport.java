package Inheritance;
class Student1{
	int rollno;
	String name;
}
class Marks1 extends Student1{
	String subject;
	float marks;
}
class Sport extends Marks1{
	String sportName;
	int points;
	
	Sport(int rollno, String name,String subject,float marks,String sportName,int points){
		this.rollno = rollno;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
		this.sportName = sportName;
		this.points = points;
		
	}
	void displayDetails() {
		System.out.println(rollno+"\t "+name+"\t "+subject+"\t\t "+marks+"\t "+sportName+"\t "+points);
	}
}
public class SttudentSport {
	public static void main(String args[]) {
		System.out.println("Rollno \t Name \t\t Subject \t Marks \t Sport \t\t Points");
		Sport s1 = new Sport(1,"Yadnyesh","Java",9.99f,"Shooting",200);
		s1.displayDetails();
	}
}
