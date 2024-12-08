import java.util.Scanner;

public class TemperatureConverter{

    public static void main(String[] args) {
        calculatorApp(); // Call the calculator application
    }
    //Actual Temperature application
    public static void calculatorApp() {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        // Variable to control the program flow
        boolean stop = false;

        while (!stop) {
            // Display a menu for the user to choose the conversion type
            System.out.println("Welcome to The Temperature Converter");
            System.out.println("Choose an option:");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");

            // Read the user's choice
            int userOption = getValidChoice(scanner);

            // Ask the user to input the temperature value
            System.out.print("Enter the temperature: ");
            double temperature = getValidTemperature(scanner);

            // Perform the conversion based on the user's choice
            double convertedTemperature;
            if (userOption == 1) {
                convertedTemperature = celsiusToFahrenheit(temperature);
                System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.\n\n", temperature, convertedTemperature);
            } else {
                convertedTemperature = fahrenheitToCelsius(temperature);
                System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.\n\n", temperature, convertedTemperature);

            }

            // Check if the user wants to continue
            int continueOption = getActiveStatus(scanner);
            if (continueOption == 2) {
                stop = true; // Exit the App

            }
        }
        // Close the scanner
        scanner.close();
    }

    // Method to handle valid menu choice input
    public static int getValidChoice(Scanner scanner) {
        int userOption = 0;
        boolean validInput = false;
        System.out.print("Please enter a number (1 or 2): ");
        while (!validInput) {
            if (scanner.hasNextInt()) {
                userOption = scanner.nextInt();
                if (userOption == 1 || userOption == 2) {
                    validInput = true;
                } else {
                    System.out.print("Invalid choice. Please enter 1 or 2: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number (1 or 2): ");
                scanner.next(); // clear the invalid input
            }
        }
        return userOption;
    }

    // Method to handle valid temperature input
    public static double getValidTemperature(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number for temperature: ");
            scanner.next(); // clear the invalid input
        }
        return scanner.nextDouble();
    }

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Method to check whether the user wants to continue
    public static int getActiveStatus(Scanner scanner) {
        int userOption = 0;
        boolean validInput = false;

        System.out.println("1. Convert another temperature");
        System.out.println("2. Quit the app");
        System.out.print("Please enter a number (1 or 2): ");
        while (!validInput) {
            if (scanner.hasNextInt()) {
                userOption = scanner.nextInt();
                if (userOption == 1 || userOption == 2) {
                    validInput = true;
                } else {
                    System.out.print("Invalid choice. Please enter 1 or 2: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number (1 or 2): ");
                scanner.next(); // clear the invalid input
            }
        }
        return userOption;
    }
}
