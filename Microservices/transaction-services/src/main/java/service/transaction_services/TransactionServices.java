package service.transaction_services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServices {
    @Autowired 
    TransactionRepository transactionrepository;
    @Autowired
    FeignToAccount feigntoaccount;

    boolean isvalid = false;
    public Transaction transfer(Transaction transaction){
        Account fromAccount = feigntoaccount.findByRootFrom(transaction.getTransactionFrom());// find the root account
        // find whether transactionTo is part of transactionDrom payee list
        int size = fromAccount.getPayee().stream().filter(o->o.getPayeeAccountNum()==transaction.getTransactionTo()).collect(Collectors.toList()).size();
        if(transaction.getTransactionFrom()==fromAccount.getAccountNumber()&&
        transaction.getTransactionFrom()!=transaction.getTransactionTo()&&size>0){
            Account toAccount = feigntoaccount.findByRootFrom(transaction.getTransactionTo());// find beneficiary account
            if(transaction.getTransactionAmount()<=fromAccount.getAccountBalance()){
                fromAccount.setAccountBalance(fromAccount.getAccountBalance()-transaction.getTransactionAmount());
                toAccount.setAccountBalance(toAccount.getAccountBalance()+transaction.getTransactionAmount());
                feigntoaccount.updateAccount(fromAccount);
                feigntoaccount.updateAccount(toAccount);
                transaction.setTransactionStatus("Success");
                transactionrepository.save(transaction);
                return transaction;
            }
            else{
                throw new RuntimeException("Transaction failed due to insufficient balance");
            }
        }
        else{
            throw new RuntimeCryptoException("Failed due to invalid from/to account number");
        }
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
        List<Transaction> fetched= transactionrepository.findAllByTransactionFrom(trfrom);
        return fetched;
    }
    
}
