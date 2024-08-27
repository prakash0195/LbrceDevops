package LbrceDevops;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class login {

    // A simple in-memory user store
    private static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Login/Signup System!");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
           
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    signUp(scanner);
                    break;
                case 2:
                    logIn(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void signUp(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please try a different username.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // In a real application, you should hash the password before storing it
        userDatabase.put(username, password);

        System.out.println("Sign up successful!");
    }

    private static void logIn(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!userDatabase.containsKey(username)) {
            System.out.println("Username does not exist. Please sign up first.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }
}
