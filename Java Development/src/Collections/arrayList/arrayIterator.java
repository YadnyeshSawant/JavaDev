package Collections.arrayList;

// Ways to iterate the elements of the collection in Java
// There are various ways to traverse the collection elements:
// By Iterator interface.
// By for-each loop.
// By ListIterator interface.
// By for loop.
// By forEach() method.
// By forEachRemaining() method.

import java.util.*;
public class arrayIterator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> data = new ArrayList<Integer>();
        int n;
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }

        // By Iterator interface.
        Iterator<Integer> itr = data.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // By for-each loop.
        for (Integer number : data) {
            System.out.println(number);
        }

        // By ListIterator interface.
        ListIterator<Integer> data1 = data.listIterator(data.size());
        while (data1.hasPrevious()) {                      // use hasPrevious() to print in reverse order
            System.out.println(data1.previous());
        }

        // By for loop.
        for (int i = 0; i < n; i++) {
            System.out.println(data.get(i));
        }

        // By forEach() method.
        data.forEach(a->{System.out.println(a);});    //here lambada function has been used


        // By forEachRemaining() method.
        itr = data.iterator();
        itr.forEachRemaining(a->{System.out.println(a);}); //here lambada function has been used
    }

}
