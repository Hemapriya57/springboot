package services.customer_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServices {
    @Autowired
    CustomerRepository services;

    //find by customer id
    public Optional<Customer> readCustomerById(int customerid){
        return services.findById(customerid);
    }
    //
    
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
