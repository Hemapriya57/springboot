package services.account_services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer>{
    Optional<Account> findByAccountNumber(long accountNumber);
}
