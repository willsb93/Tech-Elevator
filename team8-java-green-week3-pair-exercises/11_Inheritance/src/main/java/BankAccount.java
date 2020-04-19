import java.math.*;

public class BankAccount {
	private String accountNumber = "";
	private BigDecimal balance = new BigDecimal(0.0);

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public BigDecimal deposit(BigDecimal amountToDeposit) {
		this.balance = this.balance.add(amountToDeposit);
		return balance;
	}

	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		this.balance = this.balance.subtract(amountToWithdraw);
		return balance;
	}

	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		this.balance = this.balance.subtract(transferAmount);
		destinationAccount.deposit(transferAmount);
	}

}
