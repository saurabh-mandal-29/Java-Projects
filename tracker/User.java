import java.io.Serializable;

// Define the User class for storing user information
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    // Constructor to initialize User object with a username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
