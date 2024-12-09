package banking.zealous.Bank.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.zealous.Bank.Entities.Account;
import banking.zealous.Bank.Entities.Payee;
import banking.zealous.Bank.Entities.Transaction;
import banking.zealous.Bank.Repositories.AccountRepository;
import banking.zealous.Bank.Repositories.PayeeRepository;
import banking.zealous.Bank.Repositories.TransactionRepository;

@Service
public class TransactionServices {
    @Autowired 
    TransactionRepository transactionrepository;
    @Autowired
    AccountRepository accountrepository;
    @Autowired
    PayeeRepository payee;

    boolean isvalid = false;
    public Transaction transfer(Transaction transaction){
        accountrepository.findAll().forEach(v -> {    // v holds the information about the sender
            int size = v.getPayee().stream().filter(o-> o.getPayeeAccountNum()==transaction.getTransactionTo()).collect(Collectors.toList()).size(); //o represents a Payee, which only holds basic information like payeeAccountNum
            if(transaction.getTransactionFrom() == v.getAccountNumber() && 
            transaction.getTransactionFrom()!=transaction.getTransactionTo()&&size>0){ 
                Account receiver = accountrepository.findByAccountNumber(transaction.getTransactionTo()).get();
                if(transaction.getTransactionAmount() <= v.getAccountBalance()){
                    v.setAccountBalance(v.getAccountBalance()-transaction.getTransactionAmount());
                    receiver.setAccountBalance(receiver.getAccountBalance()+transaction.getTransactionAmount());
                    accountrepository.save(v);
                    accountrepository.save(receiver);
                    transaction.setTransactionStatus("Success");
                    transactionrepository.save(transaction);
                    isvalid = true;
                }
                else{
                    throw new RuntimeException("Transaction failed due to insufficient balance");
                }
            }
        } );
        if(isvalid)
            return transaction;
        else
            throw new RuntimeException("transaction failed due to account was not present");
    }
    public List<Transaction> read(){
        return transactionrepository.findAll();
    }
    public List<Transaction> readtype(String transactiontype){
        return transactionrepository.findAllByTransactionType(transactiontype);
    }
    public List<Transaction> readdate(String transactiondate){
        LocalDate userDate = LocalDate.parse(transactiondate);//parse() is a static method of LocalDate that converts a String into a LocalDate object.
        LocalDateTime startOfDay = userDate.atStartOfDay(); //atStartOfDay() is a method of the LocalDate class that returns a LocalDateTime object
        LocalDateTime endOfDay = userDate.atTime(23, 59, 59);
        return transactionrepository.findAllByTransactionDate(startOfDay,endOfDay);
    }
    public List<Transaction> readFromAndDate(long transactionfrom,String trDateTime){
        LocalDate userDate = LocalDate.parse(trDateTime);
        LocalDateTime startOfDay = userDate.atStartOfDay();
        LocalDateTime endOfDay = userDate.atTime(23, 59, 59);
        return transactionrepository.selectByTransactions(transactionfrom,startOfDay,endOfDay);
    }
    public List<Transaction> readFrom(long trfrom){
        return transactionrepository.findAllByTransactionFrom(trfrom);
    }
    
}
