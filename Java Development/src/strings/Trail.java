package strings;

public class Trail {

	public static void main(String[] args) {
		String str[] =  
			{  
			"Yadnyesh Sawamnt",
			"Ujwal Thakare"
			};  
			  
			String surName = "Thakare";  
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
			    else {
			    	System.out.println("No Name Found");
			    }
			}
		}
	}

