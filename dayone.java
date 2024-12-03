import java.util.Random;
import java.util.Scanner;

public class dayone {
    private static double balance = 1000.0;  // Starting balance for the player
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Gambling Game!");
        
        while (true) {
            System.out.println("\nYour current balance: $" + balance);
            System.out.println("Choose an action: ");
            System.out.println("1. Place a bet");
            System.out.println("2. Exit the game");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = scanner.nextInt();
            
             switch (choice) {
                case 1:
                    placeBet();  // Place a bet if the choice is 1
                    break;
                case 2:
                    System.out.println("Thanks for playing! Your final balance is $" + balance);
                    return;  // Exit the game if the choice is 2
                default:
                    System.out.println("Invalid choice, please try again.");  // Handle invalid choices
                    break;
            }
        }
    }

    private static void placeBet() {
        System.out.print("\nEnter your bet amount: $");
        double betAmount = scanner.nextDouble();

        if (betAmount > balance) {
            System.out.println("You don't have enough money to place that bet.");
            return;
        }

        // Ask player for their guess
        System.out.print("Guess a number between 1 and 10: ");
        int playerGuess = scanner.nextInt();

        // Generate a random number (the "winning" number)
        int winningNumber = random.nextInt(10) + 1;

        // Check if the player's guess is correct
        if (playerGuess == winningNumber) {
            System.out.println("Congratulations! You guessed the correct number: " + winningNumber);
            balance += betAmount;  // Player wins the bet
            System.out.println("You win $" + betAmount + "!");
        } else {
            System.out.println("Sorry! The correct number was: " + winningNumber);
            balance -= betAmount;  // Player loses the bet
            System.out.println("You lost your bet of $" + betAmount + ".");
        }

        // Check if the player has run out of money
        if (balance <= 0) {
            System.out.println("You're out of money! Game over.");
            System.exit(0);  // End the game if the player has no money left
        }
    }
}
