package controller.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class todayfile {
    List<String> skills = new  ArrayList<String>();
    public todayfile(){

    skills.add("java");
    skills.add("html");
    skills.add("css");
    }
    @GetMapping("/")
    public List<String> myskills(){
    
        return skills;
    }
    @PostMapping("/newskill")
    public String newSkill(@RequestBody String Skilled ){
       skills.add(Skilled);
       return Skilled +"has added";
    }
    @DeleteMapping("/{variable}")
    public String erase(@PathVariable("variable") String variable1){
        skills.remove(variable1);
        return variable1 + "has removed";
    }
    @PutMapping("/{indexposition}")
    public String update(@PathVariable("indexposition") int indexposition, @RequestBody String added){
        //if(indexposition>0&&indexposition<skills.size()){
        skills.set(indexposition,added);
        return added + " has updated at indexposition "+ indexposition;
   // }
   // return  added + "cannot added ";

}
}

