package project.student.registration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
    
}
