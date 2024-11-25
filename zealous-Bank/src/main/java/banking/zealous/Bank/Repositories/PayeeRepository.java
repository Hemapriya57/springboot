package banking.zealous.Bank.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import banking.zealous.Bank.Entities.Payee;

public interface PayeeRepository extends JpaRepository<Payee,Integer> {
    List<Payee> findAllByPayeeName(String payeename);
    
}
