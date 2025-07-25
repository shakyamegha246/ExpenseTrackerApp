import java.util.Scanner;

public class ExpenseTracker {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        String filename = "expenses.txt";
        manager.loadFromFile(filename);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Show Summary");
            System.out.println("6. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    manager.addExpense(new Expense(date, category, amount, description));
                    System.out.println("Expense added.");
                    break;
                case 2:
                    manager.listExpenses();
                    break;
                case 3:
                    manager.listExpenses();
                    System.out.print("Enter expense ID to edit: ");
                    int editId = Integer.parseInt(sc.nextLine()) - 1;
                    Expense old = manager.getExpense(editId);
                    if (old == null) {
                        System.out.println("Invalid ID.");
                        break;
                    }
                    System.out.print("Enter new amount (old: " + old.getAmount() + "): ");
                    double newAmount = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter new category (old: " + old.getCategory() + "): ");
                    String newCategory = sc.nextLine();
                    System.out.print("Enter new description (old: " + old.getDescription() + "): ");
                    String newDescription = sc.nextLine();
                    System.out.print("Enter new date (old: " + old.getDate() + "): ");
                    String newDate = sc.nextLine();
                    manager.editExpense(editId, new Expense(newDate, newCategory, newAmount, newDescription));
                    System.out.println("Expense updated.");
                    break;
                case 4:
                    manager.listExpenses();
                    System.out.print("Enter expense ID to delete: ");
                    int delId = Integer.parseInt(sc.nextLine()) - 1;
                    manager.deleteExpense(delId);
                    System.out.println("Expense deleted.");
                    break;
                case 5:
                    manager.showSummary();
                    break;
                case 6:
                    manager.saveToFile(filename);
                    System.out.println("Expenses saved. Exiting.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
         
        }
	}
}	
	
	