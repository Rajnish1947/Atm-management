public class ATMService {

    private Account account;

    public ATMService(Account account) {
        this.account = account;
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    public void depositAmount(double amount) {
        try {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawAmount(double amount) {
        try {
            account.withdraw(amount);
            System.out.println("Please collect your cash.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
