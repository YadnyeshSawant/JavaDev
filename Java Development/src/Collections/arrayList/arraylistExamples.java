package Collections.arrayList;

import java.util.*;

import java.util.ArrayList;

public class arraylistExamples {
    public static void main(String[] args) {
        ArrayList <String>  list1 =  new ArrayList<String>();
            list1.add("Yadnyesh");  //use add() function to add the item to the array list.
            list1.add("Sawant");
        System.out.println(list1);

        //using iterator for iterating the list
        Iterator <String> itr = list1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //Using for each loop
        for(String str: list1){
            System.out.println(str);
        }

        //setting the item in the list
        list1.set(1,"Yadnyesh Sawant");

        //getting the item in the list
        System.out.println(list1.get(1));

        //Sorting the list
        Collections.sort(list1);
        for(String str: list1){
            System.out.println(str);
        }

    }
}
