package Collections.arrayList;

import java.util.*;

public class arraylistIntExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> data = new ArrayList<Integer>();
        int n;
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            data.add(sc.nextInt());
        }

        Iterator <Integer> itr = data.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        Collections.sort(data);
        for(Integer number: data){
            System.out.println(number);
        }
    }
}
