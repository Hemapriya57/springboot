package banking.zealous.Bank.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import banking.zealous.Bank.Entities.depositVaribles;
import jakarta.transaction.Transactional;

@Repository
public interface DepositRepository extends CrudRepository<depositVaribles,Integer> {
   /*@Query("from depositVaribles where depositType = :deposittype")
    List<depositVaribles> getByType( String deposittype);*/

    List<depositVaribles> findAllBydepositType(String dtype);

    //update by hql
    @Query("update depositVaribles set depositType = :deposittype where depositId = :depositno")
    @Modifying
    @Transactional
    int updateDeposittypeById(String deposittype,int depositno);
    //delete
    @Query("delete from depositVaribles where depositId =:depositno")
    @Modifying
    @Transactional
    int deleteByid(int depositno);

}

