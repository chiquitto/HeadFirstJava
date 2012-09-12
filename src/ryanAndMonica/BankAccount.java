package ryanAndMonica;

public class BankAccount {
	private int balance = 100;
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amount) {
		System.out.println("Saque de " + amount);
		balance = balance - amount;
		System.out.println("Sobrou: " + balance);
	}
}
