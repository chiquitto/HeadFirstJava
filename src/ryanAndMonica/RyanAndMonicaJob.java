package ryanAndMonica;

public class RyanAndMonicaJob implements Runnable {

	private BankAccount backAccount = new BankAccount();

	public void run() {
		for (int x = 0; x < 10; x++) {
			makeWithdraw(10);
			if (backAccount.getBalance() < 0) {
				System.out.println("====> ESTOURO!");
			}
		}
	}

	private synchronized void makeWithdraw(int amount) {
		if (backAccount.getBalance() > 0) {
			System.out.println(Thread.currentThread().getName()
					+ " vai fazer uma retirada.");

			try {
				System.out.println(Thread.currentThread().getName()
						+ " vai dormir.");
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}

			System.out.println(Thread.currentThread().getName() + " acordou.");
			
			backAccount.withdraw(amount);
			
			System.out.println(Thread.currentThread().getName()
					+ " concluiu a retirada.");
		} else {
			System.out.println("Desculpe, não tem o suficiente para "
					+ Thread.currentThread().getName() + ".");
		}
	}

}
