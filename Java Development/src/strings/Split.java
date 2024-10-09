package strings;

public class Split {

	public static void main(String[] args) {
		String name = "My Name is Yadnyesh Sawant my fathers name is harishchdra sawant";
		
	// spliting the string with every white space
		String nameSplit[] = name.split("\\s");
		for(String w:nameSplit) {
			System.out.println(w);
			
		}
		System.out.println(nameSplit.length);
	// spliting the string with expression
		String nameSplit1[] = name.split("\\s",2);
		for(String w:nameSplit1) {
			System.out.println("\n"+w);
			
		}
	}
}
