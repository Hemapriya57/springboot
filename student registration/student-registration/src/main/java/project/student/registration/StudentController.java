package project.student.registration;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService studentservice;

    @GetMapping("/")
    public Iterable<StudentEntity> get(){
        return studentservice.readall();
    }
    
    
}
