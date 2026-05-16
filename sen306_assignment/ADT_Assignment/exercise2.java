public class OverdraftAccount extends BankAccount {

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | Balance: " + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -500) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Withdrawal denied | Balance: " + balance);
        }
    }
}