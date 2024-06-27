package Inheritance;
class Student{
	int rollno;
	String name;
	void addStudent(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
//	void displayStudent() {
//		System.out.println(rollno+" "+ name);
//	}
}
class Marks extends Student{
	String subject;
	float marks;
	void addMarks(String subject, float marks) {
		this.subject = subject;
		this.marks = marks;
	}
	void displayMarks() {
		System.out.println(rollno+"\t "+ name+"\t"+subject+"\t\t"+ marks);
	}
}
public class Exmaple {
	public static void main(String args[]){
		System.out.println("Rollno \t Name \t\tSubject \tMarks");
		Marks m1 = new Marks();
		@SuppressWarnings("unused")
		Marks m2 = new Marks();
		
		m1.addStudent(11, "Yadnyesh");
		m1.addMarks("Java", 10);
		
//		m1.displayStudent();
		m1.displayMarks();
	}
}
