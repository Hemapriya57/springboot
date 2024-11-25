package banking.zealous.Bank.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import banking.zealous.Bank.Entities.Loans;
import jakarta.transaction.Transactional;

public interface LoanRepository extends CrudRepository<Loans,Integer> {
    //update
    @Query("update Loans set loanType = :loantype where loanNumber = :loanno")
    @Transactional
    @Modifying
    int updateByType(String loantype,int loanno);

    //delete
    @Query("delete from Loans where loanNumber = :loannum")
    @Modifying
    @Transactional
    int deleteByNumber(int loannum);
}
