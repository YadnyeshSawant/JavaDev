package ThisKeyword;
//to call the parameterized constructor in the default constructor.
class C{
	C(){
		this(5);
		System.out.println("hello a");
	}
	C(int x){
		System.out.println(x);
	}
}
public class Test5 {
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		C c = new C();
	}
}
