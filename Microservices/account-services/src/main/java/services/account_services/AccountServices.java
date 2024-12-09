package services.account_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.account_services.banking.zealous.Bank.Entities.Customer;
import services.account_services.banking.zealous.Bank.Repositories.CustomerRepository;

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
