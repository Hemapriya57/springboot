package services.account_services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="feign",url = "http://localhost:8093")
public interface FeignToPayee {
    @GetMapping("/payee/sender/{root}")
    List<Payee> receiveAccount(@PathVariable("root") long root);
   
    
}
