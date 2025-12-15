//Question: Write a Java program that creates two threads. One thread should print "Even" for even numbers between 1 and 10, and the other thread should print "Odd" for odd numbers between 1 and 10. Ensure that the numbers are printed in the correct order (i.e., 1, 2, 3, 4, ...).

package multithreading;

class Th1 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Th2 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class OddEven {
    public static void main(String[] args) {
        Th1 t1 = new Th1();
        Th2 t2 = new Th2();
        t1.setName("Odd");
        t2.setName("Even");
        t1.start();
//        t1.run();
        try {
            t1.interrupt();
        } catch (Exception e) {
            System.out.println(e);
        }
        t2.start();

    }
}
