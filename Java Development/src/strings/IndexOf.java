package strings;

public class IndexOf {

	public static void main(String[] args) {
//		Java String indexOf(char) Method Example
		String str = "Yadnyesh Sawant";
		int index = str.indexOf("e");
		System.out.println(index);
//		Java String indexOf(char , start index) Method Example
		index = str.indexOf("a", 8);
		System.out.println(index);
		
		String str3 = new String("Welcome to JavaTpoint").intern(); // statement - 1  
		String str1 = new String("Welcome").intern(); // statement - 2  
		System.out.println(str1 == str3); // prints true  
	}

}
