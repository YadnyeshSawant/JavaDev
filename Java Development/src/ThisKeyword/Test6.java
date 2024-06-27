package ThisKeyword;
// To call the constructor1 in constructor2 with same parameters so that no need to initialize the parameters again in constructor2 
class Student02{
	int rollno;
	String name,course;
	float fee;
	
	Student02(int rollno,String name,String course){
		this.rollno = rollno;
		this.name = name;
		this.course = course;
	}
	Student02(int rollno,String name,String course,float fee){
		this(rollno,name,course);
		this.fee = fee;
	}
	void display() {
		System.out.println(rollno+" "+name+" "+course+" "+fee);
	}
}
public class Test6 {

	public static void main(String[] args) {
		Student02 S1 = new Student02(111,"Yadnyesh","Java");
		Student02 S2 = new Student02(112,"ujjwal","Java",9000f);
		S1.display();
		S2.display();
	}

}
