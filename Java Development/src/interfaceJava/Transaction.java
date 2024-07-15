package interfaceJava;

import java.util.Scanner;

interface Bank{
	void deposite();
	void withdraw();
	float checkBalance();
}
class SavingAccount implements Bank{
	float balance = 20000;
	float amount;
	Scanner sc = new Scanner(System.in);
	public void withdraw() {
		System.out.println("Enter the amount");
		amount = sc.nextFloat();
		if (balance > amount) {
			balance -= amount;
		}
		else {
			System.out.println("Insufficient Balance");
			System.out.println("Current Balance = "+ balance);
		}
	}
	public void deposite() {
		amount = sc.nextFloat();
		balance += amount;
	}
	public float checkBalance() {
		return balance; 
	}
	float getAmount() {
		return amount;
	}
}
class CurrentAccount implements Bank{
	float balance = 20000;
	float amount;
	Scanner sc = new Scanner(System.in);
	public void withdraw() {
		System.out.println("Enter the amount");
		amount = sc.nextFloat();
		if (balance > amount) {
			balance -= amount;
		}
		else {
			System.out.println("Insufficient Balance");
			System.out.println("Current Balance = "+ balance);
		}
	}
	public void deposite() {
		
		amount = sc.nextFloat();
		balance += amount;
	}
	public float checkBalance() {
		return balance; 
	}
	float getAmount() {
		return amount;
	}
}
public class Transaction {
	public static void main(String args[]) {
		SavingAccount sav = new SavingAccount();
		CurrentAccount cur = new CurrentAccount();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("1: Savings Account\n2:Current Acccount");
		System.out.println("Enter your choice");
		int ch = sc.nextInt();
		switch(ch) {
		case 1: ch = 0;
				System.out.println("1: Check Balance \n2: Withdraw Amount \n3:Deposite Amount");
				System.out.println("Enter your choice");
				ch = sc.nextInt();
				
				switch(ch) {
					case 1: System.out.println("Balance = "+sav.checkBalance());
						break;
					case 2: sav.withdraw();
							System.out.println("Amount withdrawn = "+sav.getAmount());
							System.out.println("Current Balance = "+sav.checkBalance());
						break;
					case 3:sav.deposite();
							System.out.println("Amount Deposited = "+sav.getAmount());
							System.out.println("Current Balance = "+sav.checkBalance());
						break;
				}
			break;
		case 2: ch = 0;
		System.out.println("1: Check Balance \n2: Withdraw Amount \n3:Deposite Amount");
		System.out.println("Enter your choice");
		ch = sc.nextInt();
		switch(ch) {
			case 1: System.out.println("Balance = "+cur.checkBalance());
				break;
			case 2: cur.withdraw();
				System.out.println("Amount withdrawn = "+cur.getAmount());
					System.out.println("Current Balance = "+cur.checkBalance());
				break;
			case 3:cur.deposite();
					System.out.println("Amount Deposited = "+cur.getAmount());
					System.out.println("Current Balance = "+cur.checkBalance());
				break;
		}
			break;
		}
	}
}
