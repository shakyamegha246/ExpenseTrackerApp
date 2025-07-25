
public class Expense {
	private String date;
	   private String category;
	   private double amount;
	   private String description;

	   public Expense(String var1, String var2, double var3, String var5) {
	      this.date = var1;
	      this.category = var2;
	      this.amount = var3;
	      this.description = var5;
	   }

	   public String getDate() {
	      return this.date;
	   }

	   public void setDate(String var1) {
	      this.date = var1;
	   }

	   public String getCategory() {
	      return this.category;
	   }

	   public void setCategory(String var1) {
	      this.category = var1;
	   }

	   public double getAmount() {
	      return this.amount;
	   }

	   public void setAmount(double var1) {
	      this.amount = var1;
	   }

	   public String getDescription() {
	      return this.description;
	   }

	   public void setDescription(String var1) {
	      this.description = var1;
	   }

	   public String toString() {
	      return String.format("%-12s | %-8s | %-8.2f | %s", this.date, this.category, this.amount, this.description);
	   }

}
