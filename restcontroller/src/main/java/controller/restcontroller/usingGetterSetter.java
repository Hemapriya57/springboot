package controller.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class usingGetterSetter {
    private String bankName;
    private String accountHolder;
    private long accountNo;
    private String ifsccode;
    private float accountBalance;

    
    public usingGetterSetter(String bankName,String accountHolder,long accountNo,String ifsccode,float accountBalance){ //costructor
        this.bankName = bankName;
        this.accountHolder = accountHolder;
        this.accountNo = accountNo;
        this.ifsccode = ifsccode;
        this.accountBalance = accountBalance;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public long getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }
    public String getIfsccode() {
        return ifsccode;
    }
    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }
    public float getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    

}
