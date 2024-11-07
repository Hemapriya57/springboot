package controller.restcontroller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class basicApi {
    @GetMapping("/")   //endpoint--->localhost:8080/
    public void host(){
        System.out.println("hai");
    }
    @GetMapping("/12")//endpoint -->localhost:8080/1
    public String host1(){
        return "good morning";
   }
   @GetMapping("/2")
   public int host2(){
    return 5+5;
   }

   //pass some data via requestparameter
   @GetMapping("/hema/{dollar1}")
   public String dollarToRupees(int dollar1){
        String value=String.valueOf(dollar1*84.07);  // valueof -->convert primitive datatype into string
         return value;
   }
   @GetMapping("/priya/{dollar2}")
   public double dollarToRupees1(@PathVariable("dollar2")int dollar2){  //pathvariable -->is used to extract the value from the uri
    return  dollar2*84.07;
   }

   //pass some data via requestbody(eg:login credential)
   @PostMapping("/login")
   public String fillingup(@RequestBody String name){
     return "hema";
   }
   @PostMapping("/interview")
   public String checkSkill(@RequestBody String skill){
    if(skill.equalsIgnoreCase("git"))
        return "you selected";
    else 
        return "rejected";
}

}
