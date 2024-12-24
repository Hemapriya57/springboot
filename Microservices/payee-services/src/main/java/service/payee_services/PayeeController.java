package service.payee_services;

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
@RestController
@RequestMapping("/payee")
public class PayeeController {
    @Autowired
    PayeeServices payeeservices;

   /*  @PostMapping("/{accountnumber}")
     public Payee create(@PathVariable("accountnumber") long accountid,@RequestBody Payee payee){
        return payeeservices.insert(accountid,payee);
    }*/
    @PostMapping("/")
    public Payee create(@RequestBody Payee payee){
        return payeeservices.insert(payee);
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
    @GetMapping("/sender/{root}")
    public List<Payee> payee(@PathVariable("root") long root){
        return payeeservices.readByRoot(root);
    }
    //update
    @PutMapping("/")
    public Payee payeeupdate(@RequestBody Payee payeedetails){
        return payeeservices.update(payeedetails);
    }

}
