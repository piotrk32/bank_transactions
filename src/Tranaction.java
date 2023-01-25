import java.io.Serializable;
import java.time.LocalDate;

public class Tranaction implements Comparable<Tranaction>, Serializable {

    private static int next = 1;
    int transactionNumber;
    Account account;
    LocalDate date;
    char operation;
    double amount;

    public Tranaction(Account account, LocalDate date, char operation, double amount) {
        this.account = account;
        this.date = date;
        this.operation = operation;
        this.amount = amount;
        transactionNumber = next++;
    }

    @Override
    public int compareTo(Tranaction o) {
        return this.transactionNumber - o.transactionNumber;
    }

    @Override
    public String toString() {
        return "Tranaction{" +
                "transactionNumber=" + transactionNumber +
                ", account=" + account +
                ", date=" + date +
                ", operation=" + operation +
                ", amount=" + amount +
                '}';
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getDate() {
        return date;
    }

    public char getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }
}
