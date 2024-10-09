package strings;
import java.util.regex.*;  

public class SubString {

	public static void main(String[] args) {
//		String str = "Yadnyesh Sawant";
//		String str2 = str.substring(2,8);
//		System.out.println(str2);
		
		//The following program finds the name of the person ending with the given i/p;
		String str[] =  
			{  
			"Praveen Kumar",  
			"Yuvraj Singh",  
			"Harbhajan Singh",  
			"Gurjit Singh",  
			"Virat Kohli",  
			"Rohit Sharma",  
			"Sandeep Singh",  
			"Milkha Singh"  
			};  
			  
			String surName = "Singh";  
			int surNameSize = surName.length();  
			System.out.println("Size of Singh = "+surNameSize);
			int size = str.length;  // size of string = total item in the string.
			System.out.println("Length of the str is "+size);  
			for(int j = 0; j < size; j++)  
			{  
			    int length = str[j].length();  
			    System.out.println(length);
	        // extracting the surname
			    String subStr = str[j].substring(length - surNameSize);  
            // checks whether the surname is equal to "Singh" or not  
			    if(subStr.equals(surName))  
			    {  
			        System.out.println(str[j]);  
			    }  
			}  
	}

}
