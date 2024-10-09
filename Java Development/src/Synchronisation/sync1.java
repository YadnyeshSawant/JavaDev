package Synchronisation;

//example of java synchronized method  
class Table{  
synchronized void printTable(int n){     //synchronized method  
	for(int i=1;i<=10;i++){  
		System.out.println(n*i);  
		try{  
			Thread.sleep(400);  
			}catch(Exception e){System.out.println(e);}  
		}  
	}  
}  

class MyThread1 extends Thread{  
	Table t;  
	MyThread1(Table t){   //constructor class thread1  
		this.t=t;  
	}  
	public void run(){  
		t.printTable(5);  
	}  
}  
class MyThread2 extends Thread{  
	Table t;  
	MyThread2(Table t){   //constructor class thread2
		this.t=t;  
	}  
	public void run(){  
		t.printTable(100);  
	}  
}  

public class sync1{  
	public static void main(String args[]){  
		Table obj = new Table();//only one object  
		MyThread1 t1=new MyThread1(obj);  
		MyThread2 t2=new MyThread2(obj);  
		t1.start();  
		t2.start();  
	}  
}  