
class Employee{
	int id;
	String name;
	
	Employee(int i,String n){
		id = i;
		name = n;
	}
	
	static String companyName = "Google";
	
	void display()
	{
		System.out.println(id+" "+name+" "+companyName);
	}
}
public class test {

	public static void main(String[] args) {
		Employee e1 = new Employee(111,"Yadnyesh");
		Employee e2 = new Employee(222,"Ujwal");
		
		e1.display();
		e2.display();
	}
}