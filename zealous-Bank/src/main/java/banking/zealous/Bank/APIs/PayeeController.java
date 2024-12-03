package banking.zealous.Bank.APIs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.zealous.Bank.Entities.Payee;
import banking.zealous.Bank.Services.PayeeServices;
@RestController
@RequestMapping("/payee")
public class PayeeController {
    @Autowired
    PayeeServices payeeservices;

     @PostMapping("/{accountnumber}")
     public Payee create(@PathVariable("accountnumber") long accountid,@RequestBody Payee payee){
        return payeeservices.insert(accountid,payee);
    }
    @GetMapping("/")
    public List<Payee> get(){
        return payeeservices.read();
    }
    //read by payee id
    @GetMapping("/{payeeno}")
    public Optional<Payee> read(@PathVariable("payeeno") int payeeno){
        return payeeservices.readId(payeeno);
    }
    //read by payeename
    @GetMapping("/name/{payeename}")
    public List<Payee> payee(@PathVariable("payeename") String payeename){
        return payeeservices.readname(payeename);
    }
    //update
    @PutMapping("/")
    public Payee payeeupdate(@RequestBody Payee payeedetails){
        return payeeservices.update(payeedetails);
    }

}
