import java.math.BigDecimal;

public class SimpleCheckingAccount extends BankAccount {

	public BigDecimal withdraw(BigDecimal amountToWithdraw) {

		BigDecimal checkingAccountBalance = getBalance();
		BigDecimal oneHundred = new BigDecimal(100.00);

		if (checkingAccountBalance.compareTo(new BigDecimal(0)) < 0) {

			checkingAccountBalance.subtract(new BigDecimal(10));

			return checkingAccountBalance;
		} else if (amountToWithdraw.compareTo(oneHundred) > 0) // Confirm if it works
		{
			return checkingAccountBalance;
		}

		checkingAccountBalance.subtract(amountToWithdraw);
		return checkingAccountBalance;
	}

}
