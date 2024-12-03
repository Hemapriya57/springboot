package banking.zealous.Bank.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.zealous.Bank.Entities.Account;
import banking.zealous.Bank.Entities.Payee;
import banking.zealous.Bank.Repositories.AccountRepository;
import banking.zealous.Bank.Repositories.PayeeRepository;

@Service
public class PayeeServices {
    @Autowired 
    PayeeRepository payeerepository;
    @Autowired
    AccountRepository accountrepository;    
    boolean isAdded=false;
    //create
    public Payee insert(long accountNumber,Payee payee){
        // Account account = accountrepository.findById(accountId).orElseThrow(()-> new RuntimeException("Account not found"));
        Account account = accountrepository.findByAccountNumber(accountNumber).orElseThrow(()-> new RuntimeException("Account not found"));
        //System.out.println(account.getAccountId()+"found");
       
        System.out.println("Account matched "+account.getAccountNumber());
        accountrepository.findAll().stream().forEach(obj->{
            System.out.println("current accoutn "+obj.getAccountNumber());
            if(obj.getAccountNumber()==payee.getPayeeAccountNum()&&account.getAccountNumber()!=payee.getPayeeAccountNum()){
                System.out.println("Account matched "+account.getAccountNumber()+" payee getting added");
                payee.setAccount(account);
                System.out.println(payee);
                payeerepository.save(payee);
                isAdded=true;
            }
        });
        if(isAdded)
            return payee;
        else
            throw new RuntimeException("Payee Could not add due sender not found / sender and receiver are same");
    }
    //get all
    public List<Payee> read(){
         return payeerepository.findAll();
    }
    //get by payeeid
    public Optional<Payee> readId(int payeeno){
        return payeerepository.findById(payeeno);
    }
    //get by name
    public List<Payee> readname(String payeename){
        return payeerepository.findAllByPayeeName(payeename);
    }
    //update
    public Payee update(Payee payeedetails){
        return payeerepository.save(payeedetails);
    }

}
