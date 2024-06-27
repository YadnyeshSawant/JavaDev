package ThisKeyword;
class Student01{
	int rollno;
	String name;
	float fee;
	
	Student01(int rollno,String name, float fee){
		this.rollno = rollno;  
		//In-order to remove the ambiguity formed due to the name of argument used in the constructor we use this keyword to refer instance variable
		this.name = name;
		this.fee = fee;
	}
	void display() {
		System.out.println(rollno+" "+name+" "+fee);
	}
}
public class Test1 {

	public static void main(String[] args) {
		Student01 s1 = new Student01(111,"Yadnyesh",5000f);
		Student01 s2 = new Student01(112,"Ujjwal",6000f);
		
		s1.display();
		s2.display();
	}
}

