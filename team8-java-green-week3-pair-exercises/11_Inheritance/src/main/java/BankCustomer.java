import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

	private String name = "";
	private String address = "";
	private String phoneNumber = "";
	private List<BankAccount> accounts = new ArrayList<BankAccount>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void addAccount(BankAccount newAccount) {

		this.accounts.add(newAccount); // Confirm if it works.

	}

	public boolean isVip(SimpleCheckingAccount checking, SavingsAccount saving) {
		BigDecimal sum = new BigDecimal(0.0);
		sum = sum.add(checking.getBalance());
		sum = sum.add(saving.getBalance());
		if (sum.compareTo(new BigDecimal(25000.00)) == 0 || sum.compareTo(new BigDecimal(25000.00)) > 0) {

			return true;
		}
		return false;
	}
}
