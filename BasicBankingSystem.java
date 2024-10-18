package basicBankingSystem;

import java.util.Scanner;

public class BasicBankingSystem {
    private double balance = 10000; 
    private final String accountNumber = "062206"; 
    private final String pin = "123456"; 
    
    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // display the current balance
    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // authenticate the user
    public boolean authenticate(String enteredAccountNumber, String enteredPin) {
        return accountNumber.equals(enteredAccountNumber) && pin.equals(enteredPin);
    }

    public static void main(String[] args) {
        BasicBankingSystem bank = new BasicBankingSystem();
        Scanner scanner = new Scanner(System.in);

        // number and PIN
        System.out.println("--- Welcome to Basic Banking System ---");
        System.out.print("Enter your account number: ");
        String enteredAccountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        // Authentication check
        if (!bank.authenticate(enteredAccountNumber, enteredPin)) {
            System.out.println("Invalid account number or PIN. Exiting...");
            return; // Exit if authentication fails
        }

        System.out.println("Authentication successful!");

        boolean exit = false;

        // Main loop for banking operations
        while (!exit) {
            System.out.println("\n--- Basic Banking System ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Deposit money
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAmount);
                    break;
                case 2:
                    // Withdraw money
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawAmount);
                    break;
                case 3:
                    // Display current balance
                    bank.displayBalance();
                    break;
                case 4:
                    // Exit the application
                    exit = true;
                    System.out.println("Exiting the banking system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
