import java.io.Serializable;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
import java.util.Date;

// Define the Expense class for storing expense information
public class Expense implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date;
    private String category;
    private double amount;
    private String username;

    // Constructor with a dateString parameter for initializing an Expense object
    public Expense(Date date, String category, double amount, String username) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.username = username;
    }

    // Getter and setter methods for date, category, amount, and username
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
