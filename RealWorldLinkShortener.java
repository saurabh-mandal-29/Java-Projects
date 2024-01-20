import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class RealWorldLinkShortener {

    // Maps for storing short-to-long and long-to-short URL mappings
    private Map<String, String> shortToLongMap = new HashMap<>();
    private Map<String, String> longToShortMap = new HashMap<>();
    
    // File path for data persistence
    private static final String DATA_FILE_PATH = "link_shortener_data.txt";

    // Entry point of the program
    public static void main(String[] args) {
        RealWorldLinkShortener linkShortener = new RealWorldLinkShortener();
        linkShortener.loadPersistedData(); // Load data from the file on program start
        linkShortener.runCLI(); // Run the CLI
    }

    // Method to run the Command Line Interface
    public void runCLI() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLink Shortener CLI Menu:");
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Save and Exit");
            System.out.print("Enter your choice (1/2/3): ");

            // Validate user input
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    shortenURL(scanner);
                    break;
                case 2:
                    expandURL(scanner);
                    break;
                case 3:
                    saveAndExit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    // Method to shorten a URL
    private void shortenURL(Scanner scanner) {
        System.out.print("Enter the long URL to shorten: ");
        String longURL = scanner.nextLine();

        // Validate long URL format
        if (!isValidURL(longURL)) {
            System.out.println("Invalid URL format. Please enter a valid URL.");
            return;
        }

        // Check if URL already shortened
        if (longToShortMap.containsKey(longURL)) {
            System.out.println("URL already shortened: " + longToShortMap.get(longURL));
        } else {
            String shortURL = generateShortURL(longURL);
            shortToLongMap.put(shortURL, longURL);
            longToShortMap.put(longURL, shortURL);
            System.out.println("Shortened URL: " + shortURL);
        }
    }

    // Method to expand a shortened URL
    private void expandURL(Scanner scanner) {
        System.out.print("Enter the short URL to expand: ");
        String shortURL = scanner.nextLine();

        // Validate short URL format
        if (!isValidShortURL(shortURL)) {
            System.out.println("Invalid short URL format. Please enter a valid short URL.");
            return;
        }

        // Check if short URL exists
        if (shortToLongMap.containsKey(shortURL)) {
            System.out.println("Expanded URL: " + shortToLongMap.get(shortURL));
        } else {
            System.out.println("Invalid short URL. Not found in records.");
        }
    }

    // Method to save data and exit the program
    private void saveAndExit() {
        persistData(); // Save data to the file before exiting
        System.out.println("Saving data and exiting Link Shortener CLI. Goodbye!");
        System.exit(0);
    }

    // Method to generate a short URL using a SHA-256 hash function
    private String generateShortURL(String longURL) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(longURL.getBytes());
            StringBuilder shortURLBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                shortURLBuilder.append(String.format("%02x", b));
            }
            return "short_" + shortURLBuilder.toString().substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error in hash function.", e);
        }
    }

    // Method to check if a URL has a valid format
    private boolean isValidURL(String url) {
        return url.matches("^https?://.+");
    }

    // Method to check if a short URL has a valid format
    private boolean isValidShortURL(String shortURL) {
        return shortURL.matches("^short_[0-9a-f]{8}$");
    }

    // Method to persist data to a file
    private void persistData() {
        try {
            Path dataFilePath = Paths.get(DATA_FILE_PATH);
            Files.createDirectories(dataFilePath.getParent());
            Files.write(dataFilePath, buildDataFileContent().getBytes());
        } catch (IOException e) {
            System.out.println("Error while persisting data: " + e.getMessage());
        }
    }

    // Method to load persisted data from a file
    private void loadPersistedData() {
        try {
            Path dataFilePath = Paths.get(DATA_FILE_PATH);
            if (Files.exists(dataFilePath)) {
                String data = Files.readString(dataFilePath);
                parseDataFileContent(data);
            }
        } catch (IOException e) {
            System.out.println("Error while loading persisted data: " + e.getMessage());
        }
    }

    // Method to build content for the data file
    private String buildDataFileContent() {
        StringBuilder content = new StringBuilder();
        for (Map.Entry<String, String> entry : shortToLongMap.entrySet()) {
            content.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        return content.toString();
    }

    // Method to parse content from the data file
    private void parseDataFileContent(String data) {
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                shortToLongMap.put(parts[0], parts[1]);
                longToShortMap.put(parts[1], parts[0]);
            }
        }
    }
}
