import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("***** Mystery Forest *****");
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("Choose your path wisely...");

        // Start the game
        startGame(scanner);
    }

    // Start the game and introduce the initial decision point
    private static void startGame(Scanner scanner) {
        System.out.println("You wake up in a mysterious forest.");
        System.out.println("You see two paths ahead of you, one leading deeper into the forest and the other leading towards a clearing.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Go deeper into the forest");
            System.out.println("2. Head towards the clearing");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    goDeeperIntoForest(scanner);
                    return; // End the game loop after a decision is made
                case 2:
                    goToClearing(scanner);
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Explore deeper into the forest
    private static void goDeeperIntoForest(Scanner scanner) {
        System.out.println("You venture deeper into the forest and stumble upon an abandoned cabin.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Enter the cabin");
            System.out.println("2. Keep moving");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    enterCabin(scanner);
                    return; // End the game loop after a decision is made
                case 2:
                    System.out.println("You decide to keep moving through the forest.");
                    System.out.println("As you walk, you hear strange noises in the distance.");
                    encounterCreature(scanner);
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Explore the clearing
    private static void goToClearing(Scanner scanner) {
        System.out.println("You walk towards the clearing and find a serene pond.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Rest by the pond");
            System.out.println("2. Explore further");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    System.out.println("You sit by the pond and enjoy the peaceful atmosphere.");
                    System.out.println("After resting for a while, you feel refreshed and continue your journey.");
                    return; // End the game loop after a decision is made
                case 2:
                    System.out.println("You decide to explore the surrounding area.");
                    System.out.println("You find a hidden cave entrance concealed by bushes.");
                    exploreCave(scanner);
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Enter the abandoned cabin
    private static void enterCabin(Scanner scanner) {
        System.out.println("You cautiously enter the abandoned cabin.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Read the book");
            System.out.println("2. Try to open the chest");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    System.out.println("You dust off the book and start reading.");
                    System.out.println("The book contains ancient spells and incantations.");
                    System.out.println("As you read further, you feel a strange power coursing through you.");
                    alternateEnding1();
                    return; // End the game loop after a decision is made
                case 2:
                    System.out.println("You attempt to open the chest, but it's locked tightly.");
                    System.out.println("Suddenly, you hear footsteps approaching from outside.");
                    encounterBandits(scanner);
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Explore the hidden cave
    private static void exploreCave(Scanner scanner) {
        System.out.println("You cautiously enter the hidden cave.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Explore further");
            System.out.println("2. Leave the cave");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    System.out.println("As you explore deeper into the cave, you encounter a sleeping dragon.");

                    // Presenting options with numbers
                    System.out.println("Select an option:");
                    System.out.println("1. Fight the dragon");
                    System.out.println("2. Sneak past the dragon");

                    int dragonChoice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

                    switch (dragonChoice) {
                        case 1:
                            System.out.println("You bravely engage the dragon in battle, but it overwhelms you with its fiery breath.");
                            System.out.println("Game Over!");
                            return; // End the game loop after a decision is made
                        case 2:
                            System.out.println("You carefully sneak past the sleeping dragon and find a hidden treasure chamber.");
                            alternateEnding2();
                            return; // End the game loop after a decision is made
                    }
                    break;
                case 2:
                    System.out.println("You decide to leave the cave and continue your journey.");
                    System.out.println("As you exit the cave, you see a group of travelers passing by.");
                    encounterTravelers(scanner);
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Encounter a mysterious creature in the forest
    private static void encounterCreature(Scanner scanner) {
        System.out.println("Suddenly, a mysterious creature emerges from the shadows.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Befriend the creature");
            System.out.println("2. Run away");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    System.out.println("You approach the creature cautiously and offer it food.");
                    System.out.println("The creature accepts your offering and leads you to its hidden lair.");
                    alternateEnding3();
                    return; // End the game loop after a decision is made
                case 2:
                    System.out.println("You panic and start running away from the creature.");
                    System.out.println("After a while, you manage to lose it and continue your journey.");
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Encounter bandits in the abandoned cabin
    private static void encounterBandits(Scanner scanner) {
        System.out.println("You hide behind a curtain as the bandits enter the cabin.");
        System.out.println("They search the cabin but fail to find anything of value.");
        System.out.println("Feeling disappointed, they leave the cabin and continue their search elsewhere.");
        System.out.println("You breathe a sigh of relief and decide to leave the cabin as well.");
        System.out.println("As you step outside, you encounter a group of travelers passing by.");
        encounterTravelers(scanner);
    }

    // Encounter friendly travelers
    private static void encounterTravelers(Scanner scanner) {
        System.out.println("The travelers greet you warmly and invite you to join them on their journey.");
        System.out.println("You have 10 chances to make a decision.");

        // Loop for 10 chances
        for (int i = 0; i < 10; i++) {
            System.out.println("You have " + (10 - i) + " chances left.");
            System.out.println("Select an option:");
            System.out.println("1. Join the travelers");
            System.out.println("2. Continue on your own");

            int choice = getNumericChoice(scanner, 2); // Ensure user input is within valid range

            switch (choice) {
                case 1:
                    System.out.println("You decide to join the travelers and embark on a new adventure together.");
                    System.out.println("Together, you explore new lands and face exciting challenges.");
                    alternateEnding4();
                    return; // End the game loop after a decision is made
                case 2:
                    System.out.println("You bid farewell to the travelers and continue your journey alone.");
                    System.out.println("As you walk further, you encounter a hidden treasure chest.");
                    alternateEnding5();
                    return; // End the game loop after a decision is made
            }
        }

        // If user runs out of chances
        System.out.println("You've run out of chances. Game Over!");
    }

    // Alternate ending 1
    private static void alternateEnding1() {
        System.out.println("You master the ancient spells from the book and become a powerful wizard.");
        System.out.println("With your newfound powers, you reshape the world according to your will.");
        System.out.println("Congratulations! You've achieved ultimate power and control.");
    }

    // Alternate ending 2
    private static void alternateEnding2() {
        System.out.println("You find a vast treasure hoard in the chamber and become incredibly wealthy.");
        System.out.println("With your newfound wealth, you live a life of luxury and adventure.");
        System.out.println("Congratulations! You've become a legendary treasure hunter.");
    }

    // Alternate ending 3
    private static void alternateEnding3() {
        System.out.println("The creature reveals itself to be a friendly guardian of the forest.");
        System.out.println("It offers to guide you through the forest and protect you from harm.");
        System.out.println("Together, you embark on a journey to restore balance to the forest.");
        System.out.println("Congratulations! You've gained a loyal companion and protector.");
    }

    // Alternate ending 4
    private static void alternateEnding4() {
        System.out.println("You travel with the friendly group of travelers and form lifelong friendships.");
        System.out.println("Together, you create unforgettable memories and overcome numerous challenges.");
        System.out.println("Congratulations! You've found true companionship and camaraderie.");
    }

    // Alternate ending 5
    private static void alternateEnding5() {
        System.out.println("You open the treasure chest and find a powerful artifact inside.");
        System.out.println("With the artifact in your possession, you become a legendary hero.");
        System.out.println("Congratulations! You've fulfilled your destiny and become a legend.");
    }

    // Utility method to get numeric choice from the user
    private static int getNumericChoice(Scanner scanner, int maxOption) {
        int choice;
        do {
            System.out.print("Enter your choice (1-" + maxOption + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > maxOption);
        scanner.nextLine(); // Consume newline
        return choice;
    }
}
