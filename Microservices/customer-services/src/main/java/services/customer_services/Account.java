package services.customer_services;

public class Account {
    private int accountId;
    private String accountType;
    private long accountNumber;
    private boolean accountStatus;
    private double accountBalance;
    private Customer customerEntity;
    public Customer getCustomerEntity() {
        return customerEntity;
    }
    public void setCustomerEntity(Customer customerEntity) {
        this.customerEntity = customerEntity;
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
