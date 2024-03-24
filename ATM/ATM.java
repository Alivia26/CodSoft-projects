import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
public static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public BankAccount() {
            this.balance = 0;
        }

        public boolean withdraw(double amount) {
            if (this.balance >= amount) {
                this.balance -= amount;
                return true;
            }
            return false;
        }

        public void deposit(double amount) {
            this.balance += amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.start();
    }
}