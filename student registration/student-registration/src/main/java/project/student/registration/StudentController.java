package project.student.registration;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

import org.springframework.ui.Model;

//import ch.qos.logback.core.model.Model;

@Controller
public class StudentController {
    @Autowired
    StudentService studentservice;

    @GetMapping("/")
    public String get(Model model){
        List<StudentEntity> liststudent = (List<StudentEntity>) studentservice.readall();
        model.addAttribute("list", liststudent);
        System.out.print("Get / ");    
        return "index"; // view
    }
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new StudentEntity());
        return "new";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentEntity std) {
        studentservice.update(std);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        StudentEntity std = studentservice.readid(id);
        mav.addObject("student", std);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        studentservice.remove(id);
        return "redirect:/";
    }
}
    
    

