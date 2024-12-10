package services.customer_services;

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

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerrepository;
    @Autowired
    CustomerServices customerservices;

    @GetMapping("/")
    public List<Customer> get(){
        return customerservices.listAllCustomer();
    }
    @PostMapping("/")
    public Customer send(@RequestBody Customer customer){
        String temp=Base64.getEncoder().encodeToString((customer.getPassword()+"").getBytes());
        customer.setPassword(temp);
    // getbytes - Converts the string into a byte array based on the platform's encoding given (usually UTF-8).
    // The + "" operation is a way to convert the result to a String if it's not already.
    // int cannot be encrypted.
        return customerservices.updatedCustomer(customer);
    }
    @GetMapping("/users/{username}")
    public Optional<Customer> getbyname(@PathVariable("username") String username){
        return customerservices.readOneCustomer(username);
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
