import java.io.*;
// import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Define the ExpenseTracker class for managing users and expenses
public class ExpenseTracker {
    private List<User> users;
    private List<Expense> expenses;
    private static final String DATA_FILE = "expense_data.ser";

    // Constructor for initializing ExpenseTracker object
    public ExpenseTracker() {
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
        loadFromFile(); // Load data from file during initialization
    }

    // Method to register a new user
    public void registerUser(User user) {
        users.add(user);
        saveToFile(); // Save data to file after adding a new user
    }

    // Method to add a new expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveToFile(); // Save data to file after adding a new expense
    }

    // Method to get a list of expenses for a specific user
    public List<Expense> getExpenses(String username) {
        List<Expense> userExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getUsername().equals(username)) {
                userExpenses.add(expense);
            }
        }
        return userExpenses;
    }

    // Method to get category-wise summation of expenses for a specific user
    public Map<String, Double> getCategorySum(String username) {
        Map<String, Double> categorySum = new HashMap<>();
        for (Expense expense : expenses) {
            if (expense.getUsername().equals(username)) {
                String category = expense.getCategory();
                double currentSum = categorySum.getOrDefault(category, 0.0);
                categorySum.put(category, currentSum + expense.getAmount());
            }
        }
        return categorySum;
    }

    // Method to save data to a file
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
            oos.writeObject(expenses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load data from a file
    @SuppressWarnings("unchecked") // Suppress the unchecked cast warning
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            users = (List<User>) ois.readObject();
            expenses = (List<Expense>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Ignore if the file doesn't exist or if it's the first run
            // This catch block prevents exceptions during deserialization
        }
    }

    // Method to get a user by username
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
