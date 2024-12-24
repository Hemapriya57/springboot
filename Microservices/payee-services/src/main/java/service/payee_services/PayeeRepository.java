package service.payee_services;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeeRepository extends JpaRepository<Payee,Integer> {
    List<Payee> findAllByRootAccount(long rootAccount);
    
}
