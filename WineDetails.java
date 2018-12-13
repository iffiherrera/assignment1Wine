/* Wine class created for the Wine Details object, it 
 sets the parameters for the wine being purchased or returned.
 */

public class WineDetails {
	// Instance variables used in wine class
	private String wineName = "";
	private int wineQuantity = 0;
	private double wineCost = 0; // both Cost & Quantity cannot be empty, so the set default is 0.
	
	
	// Constructor with 3 parameters for wine object set above 
	public WineDetails(String wineName, int wineQuantity, double wineCost) {
		this.wineName = wineName;
		this.wineQuantity = wineQuantity;
		this.wineCost = wineCost;
	}
	// Getters created for main method to access the wine object details
	public String getWineName() {
		return wineName;
	}
	public int getWineQuantity() {
		return wineQuantity;
	}
	public double getWineCost() {
		return wineCost;
	}

	// Setters created for main method to set the wine object details based on user input
	public void setWineName(String wineName) {
		this.wineName = wineName;
	}
	public void setWineQuantity(int wineQuantity) {
		this.wineQuantity = wineQuantity;
	}
	public void setWineCost(int pricePence) {
		this.wineCost = pricePence;
	}
	
	// String method with wine details called on by the main method for file writer to print.
	public String getWineOutput() {
		return String.format("%s(£%.2f), %d units, total cost = £%.2f", wineName, wineCost, wineQuantity, getWineTotal());
	}
	public double getWineTotal() {
		return wineQuantity * wineCost;
	}
}


