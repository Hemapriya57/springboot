package service.transaction_services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="feign",url = "http://localhost:8092")
public interface FeignToAccount {
    @GetMapping("/account/host/{accountNumber}")
    Account findByRootFrom(@PathVariable("accountNumber") long accountNumber);
    @PutMapping("/account/")
    Account updateAccount(@RequestBody Account account);
}
