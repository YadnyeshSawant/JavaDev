package practiceTest;
class Person{
	String name;
	int age;
	Person(String name ,int age){
		this.name = name;
		this.age = age;
	}
	void display() {
		System.out.println(name + age);
	}
}
public class Question1 {
	public static void main(String[] args) {
		Person p1 = new Person("Yadnyesh  ",20);
		Person p2 = new Person("Ujwal  ",20);
        p1.display();
        p2.display();
	}

}
