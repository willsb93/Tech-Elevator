import java.math.BigDecimal;

public class BankTeller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleCheckingAccount checkingAccount = new SimpleCheckingAccount();
		SavingsAccount savingsAccount = new SavingsAccount();

		BigDecimal amountToDeposit = new BigDecimal("25000.00");
		BigDecimal newBalance = checkingAccount.deposit(amountToDeposit);

		BigDecimal amountToTransfer = new BigDecimal("0.50");
		checkingAccount.transfer(savingsAccount, amountToTransfer);

		System.out.println("$" + checkingAccount.getBalance());
		System.out.println("$" + savingsAccount.getBalance());

		BankCustomer JoeDirt = new BankCustomer();
		JoeDirt.addAccount(checkingAccount);
		JoeDirt.addAccount(savingsAccount);
		JoeDirt.isVip(checkingAccount, savingsAccount);
		System.out.println("Is the customer a VIP ?" + " " + JoeDirt.isVip(checkingAccount, savingsAccount));

		System.out.println(String.format("Joe Dirt has %s accounts.", JoeDirt.getAccounts().size()));
	}

}
