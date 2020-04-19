import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

	public BigDecimal withdraw(BigDecimal amountToWithdraw) {

		BigDecimal savingsAccountBalance = this.getBalance();
		BigDecimal oneHundredAndFifty = new BigDecimal(150.00);
		BigDecimal serviceCharge = new BigDecimal(2.00);

		if (savingsAccountBalance.compareTo(oneHundredAndFifty) < 0) {

			savingsAccountBalance.subtract(serviceCharge);

			return savingsAccountBalance;
		} else if (amountToWithdraw.compareTo(savingsAccountBalance) > 0) // Confirm if it works
		{
			return savingsAccountBalance;
		}

		savingsAccountBalance.subtract(amountToWithdraw);
		return savingsAccountBalance;
	}

}
