package Inheritance;
class Student01{
	int rollno;
	String name;
}
class Marks01 extends Student01{
	String subject;
	float marks;
	
	Marks01(int rollno, String name,String subject, float marks) {
		this.rollno = rollno;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
		
	}
	void displayMarks() {
		System.out.println(rollno+"\t "+ name+"\t"+subject+"\t\t"+ marks);
	}
}
public class ExampleConstructor {
	public static void main(String args[]){
		System.out.println("Rollno \t Name \t\tSubject \tMarks");
		Marks01 marks1 = new Marks01(101,"Yadnyesh","Python",10);
		Marks01 marks2 = new Marks01(102,"Bhagyshree","Java",9.9f);
		marks1.displayMarks();
		marks2.displayMarks();
	}
}
