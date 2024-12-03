package banking.zealous.Bank.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private String accountType;
    @Column(unique = true)
    private long accountNumber;
    private boolean accountStatus;
    private double accountBalance;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    @JsonBackReference
    private Customer customerEntity;
    public Customer getCustomerEntity() {
        return customerEntity;
    }
    public void setCustomerEntity(Customer customerEntity) {
        this.customerEntity = customerEntity;
    }

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Payee> payee;
    public List<Payee> getPayee() {
        return payee;
    }
    public void setPayee(List<Payee> payee) {
        this.payee = payee;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public boolean isAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    
}
