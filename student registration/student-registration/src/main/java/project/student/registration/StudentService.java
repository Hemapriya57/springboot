package project.student.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;

    public List<StudentEntity> readall(){
        return (List<StudentEntity>) studentrepository.findAll();
    }
    public StudentEntity readid(int number){
        return studentrepository.findById(number).get();  //This method retrieves the value inside the Optional if it's present.calling .get() on an empty Optional will throw a NoSuchElementException.
    }
    public StudentEntity update(StudentEntity num){
        return studentrepository.save(num);
    }
    public void remove(int id){
         studentrepository.deleteById(id);
    }
}
