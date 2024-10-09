package multithreading;
public class sample2 implements Runnable{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hello From Thread");
		}
	}
	public static void main(String[] args) {
		sample2 s21 = new sample2();
		Thread th = new Thread(s21);
		th.start();
	}

}
