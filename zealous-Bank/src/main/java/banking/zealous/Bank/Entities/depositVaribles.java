package banking.zealous.Bank.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class depositVaribles {
    @Id
    private int depositId;
    private String depositName;
    private String depositType;
    private int depositRoi;
    private String depositDescription;
    
    public depositVaribles() {
    }
    

    public depositVaribles(int depositId, String depositName, String depositType, int depositRoi,
            String depositDescription) {
        this.depositId = depositId;
        this.depositName = depositName;
        this.depositType = depositType;
        this.depositRoi = depositRoi;
        this.depositDescription = depositDescription;
    }


    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public int getDepositRoi() {
        return depositRoi;
    }

    public void setDepositRoi(int depositRoi) {
        this.depositRoi = depositRoi;
    }

    public String getDepositDescription() {
        return depositDescription;
    }

    public void setDepositDescription(String depositDescription) {
        this.depositDescription = depositDescription;
    }

    

}
