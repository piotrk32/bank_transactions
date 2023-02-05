package project;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Comparable<Transaction>, Serializable {

    private static int next = 1;
    int transactionNumber;
    Account account;
    LocalDate date;
    char operation;
    double amount;

    public Transaction(Account account, LocalDate date, char operation, double amount) {
        this.account = account;
        this.date = date;
        this.operation = operation;
        this.amount = amount;
        transactionNumber = next++;
    }

    @Override
    public int compareTo(Transaction o) {
        return this.transactionNumber - o.transactionNumber;
    }

    @Override
    public String toString() {
        return "project.Tranaction{" +
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
