//Write a Java program to create a base class BankAccount with methods deposit() and withdraw(). Create two subclasses SavingsAccount and CheckingAccount. Override the withdraw() method in each subclass to impose different withdrawal limits and fees.
//This Same program can be used for ATM Machine Transaction.

import java.util.*;
import java.util.regex.*;
class BankAccount2{
	double balance = 20000;
	double amount;
	Scanner sc = new Scanner(System.in);
	
	void deposite() {
		System.out.println("Enter Amount");
		amount = sc.nextDouble();
		this.balance = balance + amount;
	}
	void withdraw() {
		System.out.println("Enter Amount");
		amount = sc.nextDouble();
		this.balance = balance - amount;
	}
	double checkBalance() {
//		System.out.println("Balance = "+ balance);
		return balance;
	}
	double getAmount() {
		return amount;
	}
}
class SavingsAccount2 extends BankAccount2{
	double amount = super.amount;
//	SavingsAccount2(double balance) {
//		super(balance);
//	}
	double getAmount() {
		return super.amount;
	}
	@Override
	void withdraw() {
//		System.out.println("Enter Amount");
//		amount = sc.nextDouble();
		if(super.balance > 1000) {
			super.withdraw();
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
	@Override
	void deposite() {
//		System.out.println("Enter Amount");
//		amount = sc.nextDouble();
		super.deposite();
	}
}
class CurrentAccount extends BankAccount2{
	double amount = super.amount;
//	CheckingAccount(double balance) {
//		super(balance);
//	}
	double getAmount() {
		return super.amount;
	}
	@Override
	void deposite() {
//		System.out.println("Enter Amount");
//		amount = sc.nextDouble();
		super.deposite();
	}
	@Override
	void withdraw() {
//		System.out.println("Enter Amount");
//		amount = sc.nextDouble();
		if(super.balance > amount) {
			super.withdraw();
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
}
public class ATMT_TRANSACTION {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pin = "1234";
		System.out.println("Enter your pin");
		String input = sc.next();
		if(Pattern.matches("^[0-9\\s]+$",input)){
			if(pin.equals(input)) {
			SavingsAccount2 sav = new SavingsAccount2();
			CurrentAccount cur = new CurrentAccount();
			int ch =0;
				System.out.println("1: Savings Account\n2:Current Acccount");
				System.out.println("Enter your choice");
				ch = sc.nextInt();
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
			else {
				System.out.println("Invalid Pin");
			}
			}
		sc.close();
	}
}