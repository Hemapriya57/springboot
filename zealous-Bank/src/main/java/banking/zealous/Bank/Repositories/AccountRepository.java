package banking.zealous.Bank.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import banking.zealous.Bank.Entities.Account;

public interface AccountRepository extends JpaRepository<Account,Integer>{
    Optional<Account> findByAccountNumber(long accountNumber);
}
