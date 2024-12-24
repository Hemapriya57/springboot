package services.account_services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {
   @Autowired
   AccountRepository accountrepository;
   @Autowired
   private FeignToPayee feignToPayee;
//post--insert
   public Account create(Account acunt){
        return accountrepository.save(acunt);
   }
   //getmapping
   public List<Account> read(){
      List<Account> fetched = accountrepository.findAll();
      fetched.stream().map(obj->{
         obj.setPayee(feignToPayee.receiveAccount(obj.getAccountNumber()));
         return obj;
      }).collect(Collectors.toList());
    return fetched;
   }
   public Account readByAccountNumber(long accountNumber){
      Account account = accountrepository.findByAccountNumber(accountNumber);
      account.setPayee(feignToPayee.receiveAccount(accountNumber));
      return account;
   }
   public List<Account> readAccountByCustomer(int customerId){
      List<Account> fetched = accountrepository.findAllByCustomer(customerId); //The use of customerId in the AccountService is primarily a logical connection to the CustomerService
      fetched.stream().map(obj->{
         obj.setPayee(feignToPayee.receiveAccount(obj.getAccountNumber()));
         return obj;
      }).collect(Collectors.toList());
    return fetched;
   }

   
}
