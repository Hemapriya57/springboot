package service.transaction_services;


public class Payee {
    private int PayeeId;
    private String payeeName;
    private long payeeAccountNum;

    private long transactionTo;
    public long getTransactionTo() {
        return transactionTo;
    }
    public void setTransactionTo(long transactionTo) {
        this.transactionTo = transactionTo;
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
                + ", transactionTo=" + transactionTo + "]";
    }
    
    
    
    
}
