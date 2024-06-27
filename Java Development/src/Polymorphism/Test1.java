//Write a Java program to create a class called Employee with methods called work() and getSalary(). Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee().
package Polymorphism;
class Employee{
	double salary;
	Employee(double salary){
		this.salary = salary;
	}
	void work() {
		System.out.println("Works as employee");
	}
	double getSalary() {
		return salary;
	}
}
class Hrmanager extends Employee{
	
	Hrmanager(double salary){
		super(salary);
	}
	void work() {
		System.out.println("Works as manager");
	}
	void addEmloyee() {
		System.out.println("Add employees");
	}
}
public class Test1 {

	public static void main(String[] args) {
		Employee e1 = new Employee(300000);
		Hrmanager hr = new Hrmanager(4500000);
		
		hr.work();
		System.out.println("Manager Salary" + hr.getSalary());
		
		e1.work();
		System.out.println("Employee Salary"+ e1.getSalary());
	}

}
