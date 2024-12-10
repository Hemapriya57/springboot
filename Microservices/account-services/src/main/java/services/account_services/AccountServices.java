package services.account_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {
   @Autowired
   AccountRepository accountrepository;
//post--insert
   public Account create(Account acunt){
        return accountrepository.save(acunt);
   }
   //getmapping
   public List<Account> read(){
    return accountrepository.findAll();
   }
   public List<Account> readAccountByCustomer(int customerId){
    return accountrepository.findAllByCustomer(customerId);
   }

   
}
