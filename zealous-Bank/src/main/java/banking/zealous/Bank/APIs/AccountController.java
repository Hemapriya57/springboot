package banking.zealous.Bank.APIs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.zealous.Bank.Entities.Account;
import banking.zealous.Bank.Repositories.AccountRepository;
import banking.zealous.Bank.Services.AccountServices;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServices accountservices;
    @PostMapping("/{abc}")
    public Account apiCreate(@PathVariable("abc") int abc,@RequestBody Account account){
        System.out.println("REceived Customer "+abc+" "+account.getAccountNumber());
        return accountservices.create(abc,account);
}
    @GetMapping("/")
    public List<Account> apiread(){
        return accountservices.read();
    }
    @GetMapping("/{accountid}")
    public Optional<Account> apiReadCustomer(@PathVariable("accountid") int accountid){
        Optional<Account> received = accountservices.readById(accountid);
        System.out.println(received.get().getPayee().size());
        return received;
    }

}
