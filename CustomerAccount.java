/* 
 The Class CustomerAccount defines the object Customer Account.
 This class stores the customer's name and current balance.
 It will get modified if a customer buys or returns wine.

 */

public class CustomerAccount {
	// Instance variable used in this class.
	private String accountName; 
	public double accountBalance; 
	
	// Constructor using the two parameters set above.
	public CustomerAccount(String accountName, double accountBalance) {
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	} 
	// Method for sale and return of wine and positive update to the customer's balance
	public void setAccountBalance(double balanceUpdate) {
		accountBalance += balanceUpdate;
		
	}
	// Getter for accessing the account name from the main method
	public String getAccountName() {
		return accountName;
	}
	// Getter for accessing the account balance from the main method
	public double getAccountBalance() {
		return accountBalance;
	}
	public String getBalanceOutput() {
		return String.format("%s. Your balance is:£%.2f", accountName,accountBalance);
	}
	public String getFinalBalance() {
		return String.format("Your new balance is:£%.2f", accountBalance);
	}

}
