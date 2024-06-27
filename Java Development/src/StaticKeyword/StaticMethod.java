package StaticKeyword;
class Student2{
	int rollno;
	String name;
	
	static String college = "ITS";
	
	static void Change() {
		college = "BBDIT";
	}
	Student2(int i, String n)
	{
		rollno = i;
		name = n;
	}
	void display() {
		System.out.println(rollno+" "+name+" "+college);
	}
	
}
public class StaticMethod {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Student2 s1 = new Student2(101,"Lalit");
		Student2 s2 = new Student2(102,"Sumant");
		s1.Change();
		s1.display();
		s2.Change();
		s2.display();
	}
}
