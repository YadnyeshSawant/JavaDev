/*Question: 
 * Write a Java program that creates two threads, where each thread prints numbers from 1 to 5. The main thread should wait for both threads to finish execution before it prints "Threads have finished execution."*/
package multithreading;

public class Trial extends Thread {
	public void run() {
		for(int i = 1;i<=5;i++) {
			try {
//				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName()+"\t" + i);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) {
		Trial t1 = new Trial();
		Trial t2 = new Trial();
		t1.setName("First");
		t2.setName("Second");
		t1.start();
		try {
			t1.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		t2.start();
		try {	
			t2.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Threads have finished their excecution");
	}
}
