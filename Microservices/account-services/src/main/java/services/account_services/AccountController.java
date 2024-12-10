package services.account_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServices accountservices;
    @PostMapping("/")
    public Account apiCreate(@RequestBody Account account){
        return accountservices.create(account);
}
    @GetMapping("/")
    public List<Account> apiread(){
        return accountservices.read();
    }
    @GetMapping("/{customerid}")
    public List<Account> apiReadCustomer(@PathVariable("customerid") int customerid){
        List<Account> received = accountservices.readAccountByCustomer(customerid);
        return received;
    }

}
