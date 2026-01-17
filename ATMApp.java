import java.util.Scanner;

public class ATMApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Account account = new Account(1234, 10000);
        ATMService atmService = new ATMService(account);

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (!account.validatePin(enteredPin)) {
            System.out.println("Invalid PIN. Access Denied.");
            return;
        }

        System.out.println("Login successful!");

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atmService.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    atmService.depositAmount(scanner.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    atmService.withdrawAmount(scanner.nextDouble());
                    break;

                case 4:
                    atmService.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
