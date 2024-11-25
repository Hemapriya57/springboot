package banking.zealous.Bank.APIs;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.zealous.Bank.Entities.Customer;
import banking.zealous.Bank.Repositories.CustomerRepository;
import banking.zealous.Bank.Services.CustomerServices;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerrepository;
    @Autowired
    CustomerServices customerservices;

    @GetMapping("/")
    public List<Customer> get(){
        return customerrepository.findAll();
    }
    @PostMapping("/")
    public Customer send(@RequestBody Customer customer){
        //String temp=Base64.getEncoder().encodeToString((customer.getPassword()+"").getBytes());
        //customer.setPassword(temp);
        return customerrepository.save(customer);
    }
    @GetMapping("/users/{username}")
    public Optional<Customer> getbyname(@PathVariable("username") String username){
        return customerrepository.findByUserName(username);
    }
    @PutMapping("/")
    public Customer apiupdate(@RequestBody Customer customer){
        return customerservices.updatedCustomer(customer);
    }
    @DeleteMapping("/")
    public void deleted(@RequestBody Customer customer ){
        customerservices.customerDelete(customer);
    }



}
