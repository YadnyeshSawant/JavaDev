package strings;

public class StrartsWith {

	public static void main(String[] args) {
        String str = "Javatpoint";    
        
        System.out.println(str.startsWith("J")); // True    
  
        System.out.println(str.startsWith("a",2)); // False   
        System.out.println(str.startsWith("a",1)); // True
// proving Java always starts with the empty string
        if(str.startsWith("")) {
        	System.out.println("The string start with empty string");
        }
        else {
        	System.out.println("The string does not start with empty string");
        }
	}

}
