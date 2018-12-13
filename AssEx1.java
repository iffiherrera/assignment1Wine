/*AssEx1 contains the majority of methods used to run this program.
  It contains a File writer that captures the account name, balance and wine order and populates the statement text file.
  It also contains multiple methods that scan user input and calculate balance stated in order to give an exact order balance.
  A returned wine only returns 80% of the price.
 
 The file writer prints out (1)Customer Account details - account name and balance
 (2) Wine details - wine name, wine quantity and price &
 (3) New/updated balance on a separate line.  */

import java.io.FileWriter; // imported file writer
import java.io.IOException; // Object imported for catching exceptions in File reader
import java.util.InputMismatchException; // Object imported for catching input error exceptions.
import java.util.Scanner; 
public class AssEx1 {
public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		FileWriter fileStatement = null; // file writer statement created outside try to be visible in finally
		try { // catching file reader exception
			String fW = "statement.txt";
			fileStatement = new FileWriter(fW); 

		// method asking user for account name, in string format with no restrictions.
		System.out.println("Please enter your account name below:");
		String account = input.nextLine();
		
		// method asking user for account balance, can be either negative or positive depending on whether the user owes money/is owed money.
		System.out.println("Please enter your account balance below:");
		
		double balance = 0;
		boolean isInt = false;
		while(isInt == false) {
			try {
				balance = input.nextDouble();
				isInt = true;
				
			}catch (InputMismatchException e) {
				System.out.println("Please enter a number value only:");
				input.nextLine();
			}
		}

		// New CustomerAccount object created with the user's input.
		CustomerAccount accountInput = new CustomerAccount(account, balance);

		System.out.printf("Welcome %s, your balance is: £%.2f.", account, balance); 

		// the File writer prints out the first line - Account name and balance
		fileStatement.write(accountInput.getBalanceOutput() + "\n");
		
		input.nextLine();

		// The program will run in a loop until user leaves wine name blank. 
		while(true) {
			System.out.println("\nPlease enter a wine name below:");
			String wineName = input.nextLine();
			if(wineName.equals("") || wineName.equals(null)) {
				break; 
			}
			else {
				// method asking user for amount of bottles purchased, can be negative or positive.
				System.out.println("Please enter the amount of bottles you wish to purchase (use - if you wish to return):");
				
				int wineQuantity = 0;
				isInt = false;
				while(isInt == false) {
			
					try { // catches exception for not entering an int.				
						wineQuantity = input.nextInt();
							isInt = true;
					
					}catch (InputMismatchException e) {
						System.out.println("Please enter an integer value only:");
						input.nextLine();
					}
				}
				input.nextLine();
				
				// method asking user for price of wine, this price can not be negative.
			System.out.println("Please enter the price of the wine:");		
			double winePrice = input.nextDouble();
			while (winePrice <= 0) { 
				System.out.println("Please enter a positive wine price:");
				winePrice = input.nextDouble();
				}
			
			// New object created for the wine details, for the file writer to print out.
			WineDetails wine = new WineDetails(wineName, wineQuantity, winePrice);
			
			int pricePence = (int)(winePrice * 100); // turns user input into an int
			int penceTotal = (pricePence * wineQuantity);
			
				if (penceTotal < 0) {// if price is less than 0 it will only update the balance with 80%
						penceTotal *= (0.80);	
			}
				
			double poundTotal = penceTotal/100d; // turns int back into double to pass to Customer Account object 			
	//		double balanceUpdate = poundTotal + balance;
			accountInput.setAccountBalance(poundTotal);
			
			input.nextLine();
			
			System.out.printf("Your new balance is: £%.2f",accountInput.getAccountBalance());
			
			// File writer prints the second line which includes wine name, quantity & cost
			fileStatement.write(wine.getWineOutput() + "\n");
			}
			
			// File writer print the third line which is an updated account balance on a new separate line.	
			fileStatement.write(accountInput.getFinalBalance() + "\n");
			}
		
			}catch(IOException f) {
				f.printStackTrace();
			}finally { // catching IO exception, to close file reader
				if(fileStatement !=null) {
				try {
					fileStatement.close(); // file writer closed.
				}catch(IOException f) {
					f.printStackTrace(); 
				}
			}
		}
		input.close();
	}
}





