package entities.all;
import java.util.Scanner;

public class Financial{

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Get input for amount, rate, and time
        System.out.print("Enter the principal amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the time period (in years): ");
        double time = scanner.nextDouble();

        // Calculate the return on investment
        double returnAmount = calculateReturn(amount, rate, time);

        // Print the result
        System.out.println("The return on investment is: " + returnAmount);

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    // Function to calculate the return on investment
    private static double calculateReturn(double amount, double rate, double time) {
        return amount * rate * time / 100;
    }
}

