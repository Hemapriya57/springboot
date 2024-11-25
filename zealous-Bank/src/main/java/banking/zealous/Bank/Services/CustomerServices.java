package banking.zealous.Bank.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.zealous.Bank.Entities.Customer;
import banking.zealous.Bank.Repositories.CustomerRepository;
@Service
public class CustomerServices {
    @Autowired
    CustomerRepository services;

    //findbyusername
    public Optional<Customer> readOneCustomer(String username){
        return services.findByUserName(username);
    }
    //update
    public Customer updatedCustomer(Customer customer){
        return services.save(customer);
    }
    //delete
    public void customerDelete(Customer customer){
        services.delete(customer);
    }
}
