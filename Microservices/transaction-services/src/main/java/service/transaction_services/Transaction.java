package service.transaction_services;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int tansctionId;
    private String transactionType;
    @Column(nullable = false)
    private long transactionFrom;
    @Column(nullable = false)
    private long transactionTo;
    private double transactionAmount;
    @UpdateTimestamp
    private LocalDateTime transactionDate;
    @Column(nullable =  false,columnDefinition = "varchar(255) default 'In progress'")
    private String transactionStatus;
    public int getTansctionId() {
        return tansctionId;
    }
    public void setTansctionId(int tansctionId) {
        this.tansctionId = tansctionId;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public long getTransactionFrom() {
        return transactionFrom;
    }
    public void setTransactionFrom(long transactionFrom) {
        this.transactionFrom = transactionFrom;
    }
    public long getTransactionTo() {
        return transactionTo;
    }
    public void setTransactionTo(long transactionTo) {
        this.transactionTo = transactionTo;
    }
    public double getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getTransactionStatus() {
        return transactionStatus;
    }
    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
    
}
