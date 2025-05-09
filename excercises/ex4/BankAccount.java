package ap.excercises.ex4;

public class BankAccount {
    private double balance;
    private double transactionFee;
    private int transactionCount;
    private int freeTransactions;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        transactionFee = 0.0;
        transactionCount = 0;
        freeTransactions = 0;
    }

    public void setTransactionFee(double fee) {
        transactionFee = fee;
    }

    public void setFreeTransactions(int free) {
        freeTransactions = free;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionCount++;
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactionCount++;
    }

    public void deductMonthlyCharge() {
        int chargeableTransactions = Math.max(0, transactionCount - freeTransactions);
        double monthlyCharge = chargeableTransactions * transactionFee;
        balance -= monthlyCharge;
        transactionCount = 0; // Reset for next month
    }

    public double getBalance() {
        return balance;
    }
}
