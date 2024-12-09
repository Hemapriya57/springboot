package banking.zealous.Bank.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import banking.zealous.Bank.Entities.Transaction;
import jakarta.transaction.Transactional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findAllByTransactionType(String transactiontype);

    @Query("from Transaction where transactionDate between :startDateTime and :endDateTime")
    List<Transaction> findAllByTransactionDate(LocalDateTime startDateTime,LocalDateTime endDateTime);
    
    List<Transaction> findAllByTransactionFrom(long transactionfrom);
    
    @Query("from Transaction where transactionFrom = :transactionfrom and transactionDate between :startDateTime and :endDateTime")
    List<Transaction> selectByTransactions(long transactionfrom,LocalDateTime startDateTime,LocalDateTime endDateTime);

}
