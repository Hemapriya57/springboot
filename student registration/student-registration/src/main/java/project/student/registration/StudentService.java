package project.student.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Id;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;

    public Iterable<StudentEntity> readall(){
        return studentrepository.findAll();
    }
    public Optional<StudentEntity> readid(int number){
        return studentrepository.findById(number);
    }
    public StudentEntity update(StudentEntity num){
        return studentrepository.save(num);
    }
    public void remove(int id){
         studentrepository.deleteById(id);
    }
}
