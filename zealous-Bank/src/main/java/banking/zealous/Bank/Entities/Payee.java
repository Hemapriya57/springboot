package banking.zealous.Bank.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PayeeId;
    private String payeeName;
    @Column(unique = true)
    private long payeeAccountNum;

    @ManyToOne
    @JoinColumn(name = "account_Id", nullable = false)
    @JsonBackReference
    private Account account;
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPayeeId() {
        return PayeeId;
    }
    public void setPayeeId(int payeeId) {
        PayeeId = payeeId;
    }
    public String getPayeeName() {
        return payeeName;
    }
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }
    public long getPayeeAccountNum() {
        return payeeAccountNum;
    }
    public void setPayeeAccountNum(long payeeAccountNum) {
        this.payeeAccountNum = payeeAccountNum;
    }
    @Override
    public String toString() {
        return "Payee [PayeeId=" + PayeeId + ", payeeName=" + payeeName + ", payeeAccountNum=" + payeeAccountNum
                + ", account=" + account + "]";
    }
    
    
}