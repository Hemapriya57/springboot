package service.payee_services;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payeeId;
    private String payeeName;
    private long payeeAccountNum;// beneficiaryAccountNumber
    
    private long transactionTo;
    public long getTransactionTo() {
        return transactionTo;
    }
    public void setTransactionTo(long transactionTo) {
        this.transactionTo = transactionTo;
    }

    private long rootAccount;// sender account number
    public long getRootAccount() {
        return rootAccount;
    }
    public void setRootAccount(long rootAccount) {
        this.rootAccount = rootAccount;
    }
    public int getPayeeId() {
        return payeeId;
    }
    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
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
        return "Payee [PayeeId=" + payeeId + ", payeeName=" + payeeName + ", payeeAccountNum=" + payeeAccountNum
                + ", rootAccount=" + rootAccount + "]";
    }
    
    
    
}
