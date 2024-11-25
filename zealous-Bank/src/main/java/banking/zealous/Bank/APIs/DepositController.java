package banking.zealous.Bank.APIs;

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

import banking.zealous.Bank.Entities.depositVaribles;
import banking.zealous.Bank.Repositories.DepositRepository;
import jakarta.websocket.server.PathParam;

@RestController
//@RequestMapping("/deposit")
public class DepositController {
    @Autowired
    DepositRepository depositrepository;

    @PostMapping("/")
    public depositVaribles add(@RequestBody depositVaribles value){
        depositrepository.save(value);
        return value;
    }
    @GetMapping("/")
    public List<depositVaribles> read(){
        return (List<depositVaribles>)  depositrepository.findAll();
        
    }
    @GetMapping("/{depositid}")
    public Optional<depositVaribles> readonly(@PathVariable("depositid") int depositid){
        return depositrepository.findById(depositid);
    }
    @GetMapping("/typed/{dtype}")
    public List<depositVaribles> readtype(@PathVariable("dtype") String dtype){
        return depositrepository.findAllBydepositType(dtype);
    }

    /*@GetMapping("/type/{deposittype}")
    public List<depositVaribles> read(@PathVariable("deposittype") String deposittype){
        return depositrepository.getByType(deposittype);*/

    @PutMapping("/put/{deposittype}/{depositno}")
    public String update(@PathVariable("deposittype") String deposittype ,@PathVariable("depositno") int depositno){
        return depositrepository.updateDeposittypeById(deposittype,depositno)+" Deposit Type was updated";
            
    }
    @DeleteMapping("/{depositno}")
    public String delete(@PathVariable("depositno") int depositno){
        return depositrepository.deleteByid(depositno)+" deleted";
    }
    
    
}

