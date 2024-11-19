package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; //all methods in stereotype are bean

import jakarta.transaction.Transactional;

/*crudrepository  and JpaRepository contains the methods of
save ---> insert,update
findAll --> select
findById --> select by using primary key
delete,deleteById*/
/* there are three methods
 * 1. custom methods via property name without any HQL/SQL:
 *   read:
 *     syntax:findAllByPropertyName --> fecth multiple records by given property which exactly = to the value
        property name --> data members and data attributes

    2. custom methods via hibernate query
        HQl query completeley depends on entity and its property name
        eg: from laptop; --> avoid select *
        eg:select lapmodel from laptop;

    3. custom methods via sql
        SQL completely depends on the table and column names
        eg:select * from pc;
        eg: select pc_model from pc;
 */

@Repository
public interface Repositoryhema extends CrudRepository<laptop,String> {
    // 1  custom methods via property name
    List<laptop> findAllByLapmemory(int memory);
  
    //2   custom methods via hibernate query

    @Query("from laptop where lapprice<= :price")
    List<laptop> fetchAmount(int price);

    @Query("select lapmodel from laptop")
    List<String> fetchmodel();

    //3  custom methods via sql
    @Query(value = "select * from pc where pc_memory<=:memory and pc_price<=:amount",nativeQuery = true)
    List<laptop> fetchData(int memory,int amount);


    //update by hql
    @Query("update laptop set lapprice = lapprice - 500 ")
    @Transactional
    @Modifying
    int updatelapprice();

    //update by sql
    @Query(value = "update pc set pc_price = 75000 where pc_model = 'lenova'",nativeQuery=true)
    @Transactional
    @Modifying
    int updatelenova();

    //delete by hql
    @Query(value ="delete from pc where pc_model = :name",nativeQuery = true)
    @Modifying
    @Transactional
    int deleteByModel(String name);
}
