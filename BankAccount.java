import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {

    static ArrayList<User> users = new ArrayList<>(); // Store multiple users

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank Account app!");

        boolean running = true;
        while (running) {
            System.out.print("Are you a new user? (yes/no): ");
            String isNewUser = scanner.nextLine();

            User currentUser = null;

            if (isNewUser.equalsIgnoreCase("yes")) {
                // Create a new user
                System.out.print("Enter your first name: ");
                String firstname = scanner.nextLine();

                System.out.print("Enter your last name: ");
                String lastname = scanner.nextLine();

                System.out.print("Enter your email: ");
                String email = scanner.nextLine();

                System.out.print("Enter your initial balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume leftover newline

                currentUser = new User(firstname, lastname, email, balance);
                users.add(currentUser);

                System.out.println("\nUser created successfully!");
                System.out.println("Name: " + currentUser.getFirstname() + " " + currentUser.getLastname());
                System.out.println("Email: " + currentUser.getEmail());
                System.out.println("Balance: $" + currentUser.getBalance());
                System.out.println("Account Number: " + currentUser.getAccountNumber());

            } else {
                // Existing user login
                System.out.print("Please enter your email to login: ");
                String email = scanner.nextLine();
                boolean found = false;

                for (User user : users) {
                    if (user.getEmail().equalsIgnoreCase(email)) {
                        currentUser = user;
                        found = true;
                        System.out.println("Welcome back, " + currentUser.getFirstname() + " "
                                + currentUser.getLastname() + " " + currentUser.getAccountNumber() + "!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("User not found. Please register as a new user.");
                    continue; // Go back to the beginning of the loop
                }
            }

            // Operations loop for the current user
            String response = "yes";
            while (response.equalsIgnoreCase("yes")) {
                System.out.println("\nHere are the operations you can perform:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.println("5. List Users");
                System.out.print("Choose an option (1-5): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        currentUser.deposit(depositAmount);
                        System.out.println("Deposited: $" + depositAmount);
                        System.out.println("New Balance: $" + currentUser.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        currentUser.withdraw(withdrawAmount);
                        System.out.println("New Balance: $" + currentUser.getBalance());
                        break;
                    case 3:
                        System.out.println("Current Balance: $" + currentUser.getBalance());
                        break;
                    case 4:
                        response = "no"; // exit the operations loop
                        break;
                    case 5:
                        System.out.print("Are you an admin user? (yes/no): ");
                        String isAdmin = scanner.nextLine();
                        if (isAdmin.equalsIgnoreCase("yes")) {
                            System.out.print("Kindly enter your admin password: ");
                            String adminPassword = scanner.nextLine();
                            if (adminPassword.equals("admin123")) {
                                System.out.println("Admin access granted.");
                                // Admin-specific actions can be added here
                                System.out.println("List of all users:");
                                for (User user : users) {
                                    System.out.println("Name: " + user.getFirstname() + " " + user.getLastname()
                                            + ", Email: " + user.getEmail() + ", Balance: $" + user.getBalance()
                                            + ", Account Number: " + user.getAccountNumber());
                                }
                            }
                        } else {
                            System.out.println("Admin access denied.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                if (!response.equalsIgnoreCase("no")) {
                    System.out.print("Do you want to perform another operation? (yes/no): ");
                    response = scanner.nextLine();
                }
            }

            // Ask if another user wants to log in or create account
            System.out.print("\nDo you want to continue with another user? (yes/no): ");
            String continueProgram = scanner.nextLine();
            if (continueProgram.equalsIgnoreCase("no")) {
                running = false;
            }
        }

        System.out.println("Thank you for using the Bank Account app!");
        scanner.close();
    }
}
