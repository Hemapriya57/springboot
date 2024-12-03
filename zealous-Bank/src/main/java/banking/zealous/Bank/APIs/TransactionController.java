package banking.zealous.Bank.APIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.zealous.Bank.Entities.Transaction;
import banking.zealous.Bank.Services.TransactionServices;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
@Autowired
TransactionServices transactionservices;

    @PostMapping("/")
    public Transaction create(@RequestBody Transaction value){
        try{
            return transactionservices.transfer(value);
        }
        catch(RuntimeException runtimeException){
            throw runtimeException;
        }
    }
}
