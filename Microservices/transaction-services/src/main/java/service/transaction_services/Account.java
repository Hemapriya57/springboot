package service.transaction_services;

import java.util.List;

public class Account {
    private int accountId;
    private String accountType;
    private long accountNumber;
    private boolean accountStatus;
    private double accountBalance;
    private transient List<Payee> payee;
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
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", accountType=" + accountType + ", accountNumber=" + accountNumber
                + ", accountStatus=" + accountStatus + ", accountBalance=" + accountBalance + "]";
    }

    
}
