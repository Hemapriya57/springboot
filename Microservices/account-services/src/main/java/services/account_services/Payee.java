package services.account_services;

public class Payee {
    private int payeeId;
    private String payeeName;
    private long payeeAccountNum;
    private long rootAccount;
    

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
