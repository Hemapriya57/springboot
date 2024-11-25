package banking.zealous.Bank.Entities;

import java.util.List;

import jakarta.persistence.CascadeType; // Use this!
//import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerStatus;
    private long customerContact;
    @Column(unique = true)
    private String userName;
    private int password;
    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Account> myAccounts;  //logical connection
    public List<Account> getMyAccounts() {
        return myAccounts;
    }
    public void setMyAccounts(List<Account> myAccounts) {
        this.myAccounts = myAccounts;
    }
    public Customer() {
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerStatus() {
        return customerStatus;
    }
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    public long getCustomerContact() {
        return customerContact;
    }
    public void setCustomerContact(long customerContact) {
        this.customerContact = customerContact;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int temp) {
        this.password = temp;
    }
    
    
}
