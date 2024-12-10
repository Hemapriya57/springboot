package services.customer_services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="feign",url = "http://localhost:8092")
public interface FeignToAccount {
    @GetMapping("/account/{customerId}")
    List<Account> receiveAccount(@PathVariable("customerId") int customerId);
    
    
    
}