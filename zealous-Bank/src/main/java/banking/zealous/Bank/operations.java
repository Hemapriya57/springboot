package banking.zealous.Bank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class operations {
    @Autowired
    HibernateRepository hibernaterepository;

    @PostMapping("/")
    public depositVaribles add(@RequestBody depositVaribles value){
        hibernaterepository.save(value);
        return value;
    }
    @GetMapping("/")
    public List<depositVaribles> read(){
        return (List<depositVaribles>)  hibernaterepository.findAll();
        
    }
}
