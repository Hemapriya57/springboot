package banking.zealous.Bank.APIs;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/")
    public List<Transaction> select(){
        return transactionservices.read();
    }
    @GetMapping("/transactiontype/{transactiontype}")
    public List<Transaction> read(@PathVariable("transactiontype") String transactiontype){
        return transactionservices.readtype(transactiontype);
    }
    @GetMapping("/transactiondate/{transactiondate}")
    public List<Transaction> readList(@PathVariable("transactiondate") String transactiondate){
        return transactionservices.readdate(transactiondate);
    }
    @GetMapping("/trfromanddate/{trfrom}/{trdate}")
    public List<Transaction> readTransactions(@PathVariable("trfrom") long trfrom,@PathVariable("trdate") String tradate){
        return transactionservices.readFromAndDate(trfrom, tradate);
    }
    @GetMapping("/trfrom/{trfrom}")
    public List<Transaction> readTransactionFrom(@PathVariable("trfrom") long trfrom){
        return transactionservices.readFrom(trfrom);
    }


}
