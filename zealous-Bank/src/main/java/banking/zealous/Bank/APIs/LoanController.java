package banking.zealous.Bank.APIs;

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
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.service.annotation.DeleteExchange;

import banking.zealous.Bank.Entities.Loans;
import banking.zealous.Bank.Repositories.LoanRepository;

@RestController
@RequestMapping("/loan")
public class LoanController {
@Autowired 
LoanRepository loanrepository;

@GetMapping("/")
public Iterable<Loans> read(){
    return loanrepository.findAll();
}
@PostMapping("/")
public Loans insert(@RequestBody Loans loan){
    return loanrepository.save(loan);
}
@GetMapping("/{acctno}")
public Optional<Loans> readLoans(@PathVariable("acctno") int acctno){
     return loanrepository.findById(acctno);
}
@PutMapping("/abc/{loantype}/{loanno}")
public String update(@PathVariable("loanno") int loanno ,@PathVariable("loantype") String loantype){
    return loanrepository.updateByType(loantype,loanno)+" Loan Type was updated";
    
}
@DeleteMapping("/{loannum}")
public String delete(@PathVariable("loannum") int loannum){
     return loanrepository.deleteByNumber(loannum)+"your account was closed";
}

}
