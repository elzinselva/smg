import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(account, scanner);
        atm.start();
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount, Scanner scanner) {
        this.bankAccount = bankAccount;
        this.scanner = scanner;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            printOptions();
            int choice = scanner.nextInt();
            exit = performAction(choice);
        }
    }

    private void printOptions() {
        System.out.println
        ("ATM Menu:");
        System.out.println("Do you want to check balance? (If so enter 1)");
        System.out.println("Do you want to withdraw money? (If so enter 2)");
        System.out.println("Do you want to deposit money? (If so enter 3)");
        System.out.println("Do you want to exit? (If so enter 4)");
    }

    private boolean performAction(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                System.out.println("Thank you for using our ATM system! Exiting...");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + bankAccount.getBalance());
    }

    private void withdrawMoney() {
        System.out.println("Enter the amount you would like to withdraw:");
        double amount = scanner.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Transaction successful. Your new balance is: " + bankAccount.getBalance());
        } else {
            System.out.println("Unfortunately, the withdrawal amount exceeds your current balance. Your balance is: " + bankAccount.getBalance());
        }
    }

    private void depositMoney() {
        System.out.println("Enter the amount you would like to deposit:");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("Transaction successful. Your new balance is: " + bankAccount.getBalance());
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}