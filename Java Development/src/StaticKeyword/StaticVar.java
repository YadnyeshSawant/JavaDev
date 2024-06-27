package StaticKeyword;
import java.util.*;
class Student{
	int rollno;
	String name;
	
	static String college = "ITS";
	
	Student(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rollno");
		rollno = sc.nextInt();
		System.out.println("Enter name");
		name = sc.next();
	}
	
	void display() {
		System.out.println(rollno+" "+name+" "+college);
	}
}
public class StaticVar{

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.display();
		s2.display();

	}

}
