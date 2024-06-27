package ThisKeyword;
//to call the default constructor in the parameterized constructor 
class B{
	B(){
		System.out.println("Hello a");
	}
	B(int x){
		this(); 
		System.out.println(x);
		System.out.println("This output was genrated after calling parameterized constructor");
	}
}
public class Test4 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		B b = new B(10);
	}
}