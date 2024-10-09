package multithreading;

class sample extends Thread{
	public void run() {
		for(int i =1;i<=5;i++) {
			try {				
				System.out.println(Thread.currentThread().getName() +"\t"+ i);
				Thread.sleep(500);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
}
public class Q2 {
	public static void main(String[] args) {
		sample s1 = new sample();
		sample s2 = new sample();
		s1.setName("frist");
		s1.start();
		try {
			s1.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		s2.start();

	}

}
