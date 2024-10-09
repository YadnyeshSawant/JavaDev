package strings;

public class GetBytes {

	public static void main(String[] args) {
		byte str[];
		String s = "A";
		str = s.getBytes();
		for (int i = 0; i < str.length; i++) {	
			System.out.println(str[i]);
		}
		String s2 = new String(str);
		System.out.println(s2);
		String s1="this is index of example";  
		int index1=s1.indexOf("index");
		System.out.println(index1);//2 8  
	}
}
