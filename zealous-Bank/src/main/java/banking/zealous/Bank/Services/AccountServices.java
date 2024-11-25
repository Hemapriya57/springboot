package banking.zealous.Bank.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.zealous.Bank.Entities.Account;
import banking.zealous.Bank.Entities.Customer;
import banking.zealous.Bank.Repositories.AccountRepository;
import banking.zealous.Bank.Repositories.CustomerRepository;

@Service
public class AccountServices {
   @Autowired 
   CustomerRepository customerrepository;
   @Autowired
   AccountRepository accountrepository;
//post--insert
   public Account create(int customerId,Account acunt ){
        Customer cust = customerrepository.findById(customerId).orElseThrow(()->new RuntimeException("Customer Not Found"));
        System.out.println(cust.getCustomerId()+"found");
        acunt.setCustomerEntity(cust);
        System.out.println(acunt);
        return accountrepository.save(acunt);
   }
   //getmapping
   public List<Account> read(){
    return accountrepository.findAll();
   }
   public Optional<Account> readById(int accountid){
    return accountrepository.findById(accountid);
   }

   
}
