package services.customer_services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServices {
    @Autowired
    CustomerRepository customerrepository;
    @Autowired
    FeignToAccount feignToAccount;

    //find by customer id
    public Optional<Customer> readCustomerById(int customerid){
        return customerrepository.findById(customerid);
    }
    //mapping-getmapping
    public List<Customer> listAllCustomer(){
        List<Customer> fetched= customerrepository.findAll();
        fetched.stream().map(obj -> {
            obj.setMyAccounts(feignToAccount.receiveAccount(obj.getCustomerId()));
            return obj; 
        }).collect(Collectors.toList());
        return fetched;
    }
    
    //findbyusername
    public Optional<Customer> readOneCustomer(String username){
        Optional<Customer> fetched= customerrepository.findByUserName(username);
        fetched.stream().map(obj -> {
            obj.setMyAccounts(feignToAccount.receiveAccount(obj.getCustomerId()));
            return obj; 
        }).collect(Collectors.toList());
        return fetched;
    }
    //update
    public Customer updatedCustomer(Customer customer){
        return customerrepository.save(customer);
    }
    //delete
    public void customerDelete(Customer customer){
        customerrepository.delete(customer);
    }
}
