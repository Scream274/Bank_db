package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "my_transactions")
public class MyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Float sum;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "to_account")
    private Account toAccount;

    private String type;

    public MyTransaction(Float sum, Account account, Account to_account, String type) {
        this.sum = sum;
        this.account = account;
        this.toAccount = to_account;
        this.type = type;
    }

    public MyTransaction() {
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account to_account) {
        this.toAccount = to_account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTransaction that = (MyTransaction) o;
        return id == that.id && Objects.equals(sum, that.sum) && Objects.equals(account, that.account) && Objects.equals(toAccount, that.toAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, account, toAccount);
    }

    @Override
    public String toString() {

        String fromNumber = "ATM";
        String toNumber = "ATM";

        if (account != null) {
            fromNumber = String.valueOf(account.getNumber());
        }
        if (toAccount != null) {
            toNumber = String.valueOf(toAccount.getNumber());
        }

        return "MyTransaction{" +
                "id=" + id +
                ", sum=" + sum +
                ", from: " + fromNumber +
                ", to: " + toNumber + " | type: " + type +
                '}';
    }
}
