import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Define the ConsoleUI class for interacting with the ExpenseTracker through the console
public class ConsoleUI {
    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Register User");
                System.out.println("2. Add Expense");
                System.out.println("3. View Expenses");
                System.out.println("4. View Category-wise Summation");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String regUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String regPassword = scanner.nextLine();
                        User newUser = new User(regUsername, regPassword);
                        expenseTracker.registerUser(newUser);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        String expenseUsername = scanner.nextLine();
                        User user = expenseTracker.getUser(expenseUsername);
                        if (user != null) {
                            try {
                                System.out.print("Enter expense date (yyyy-MM-dd): ");
                                String dateString = scanner.nextLine();
                                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                                System.out.print("Enter expense category: ");
                                String category = scanner.nextLine();
                                System.out.print("Enter expense amount: ");
                                double amount = scanner.nextDouble();
                                scanner.nextLine(); // Consume newline
                                Expense newExpense = new Expense(date, category, amount, expenseUsername);
                                expenseTracker.addExpense(newExpense);
                            } catch (ParseException e) {
                                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter username: ");
                        String viewUsername = scanner.nextLine();
                        List<Expense> userExpenses = expenseTracker.getExpenses(viewUsername);
                        for (Expense expense : userExpenses) {
                            System.out.println(expense.getDate() + " | " + expense.getCategory() + " | $" + expense.getAmount());
                        }
                        break;
                    case 4:
                        System.out.print("Enter username: ");
                        String sumUsername = scanner.nextLine();
                        Map<String, Double> categorySum = expenseTracker.getCategorySum(sumUsername);
                        for (Map.Entry<String, Double> entry : categorySum.entrySet()) {
                            System.out.println(entry.getKey() + ": $" + entry.getValue());
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    }
}
