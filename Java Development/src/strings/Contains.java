package strings;

public class Contains{
	public static void main(String[] args) {
		String str = "Welcome to Java Course";
		boolean result = str.contains("Java");
		System.out.println(result);
		
	// Else using it in direct if statement
		
		if(str.contains("Java")){
			System.out.println("Java is present in the string");
		}
		else {
			System.out.println("No string Found");
		}
	}

}
