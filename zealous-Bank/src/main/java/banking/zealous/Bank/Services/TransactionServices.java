package banking.zealous.Bank.Services;

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
                    transaction.setTransactionStatus("Success");
                    v.setAccountBalance(v.getAccountBalance()-transaction.getTransactionAmount());
                    transactionrepository.save(transaction);
                    receiver.setAccountBalance(receiver.getAccountBalance()+transaction.getTransactionAmount());
                    accountrepository.save(v);
                    accountrepository.save(receiver);
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
    
}
