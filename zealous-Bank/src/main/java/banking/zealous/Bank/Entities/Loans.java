package banking.zealous.Bank.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Loans {
    @Id
    private int loanNumber;
    private String loanName;
    private String loanType;
    private int loanRoi;
    private String loanDescription;
    
    public Loans() {
    }
    public int getLoanNumber() {
        return loanNumber;
    }
    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }
    public String getLoanName() {
        return loanName;
    }
    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public int getLoanRoi() {
        return loanRoi;
    }
    public void setLoanRoi(int loanRoi) {
        this.loanRoi = loanRoi;
    }
    public String getLoanDescription() {
        return loanDescription;
    }
    public void setLoanDescription(String loanDescription) {
        this.loanDescription = loanDescription;
    }
}
