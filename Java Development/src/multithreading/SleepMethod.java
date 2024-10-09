package multithreading;
public class SleepMethod extends Thread {
	public void run() {
				for(int i =0;i<=5;i++) {
					try{
						Thread.sleep(500);				
					}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println(i);
			System.out.println("Im a new thread");
			}
		}
	public static void main(String args[]) {
		SleepMethod s1 = new SleepMethod();
		SleepMethod s2 = new SleepMethod();
		s1.start();
		s2.start();
		try {
			s1.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
