package banking.zealous.Bank;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateRepository extends CrudRepository<depositVaribles,Integer> {
    

}
