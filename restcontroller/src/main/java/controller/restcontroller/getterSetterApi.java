package controller.restcontroller;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class getterSetterApi {
   // List<usingGetterSetter> skills = new  ArrayList<usingGetterSetter>();
   // public getterSetterApi(){
        //skills.add(new getterSetterApi("canarabank","hema","76686876","qw09987","89997.0"));
        List<usingGetterSetter> accounts = Stream.of(new usingGetterSetter("canarabank","hema",7668688876L,"qw09987",8000.0F),
        new usingGetterSetter ("axisbank","priya",12345678L,"qw09987",10000.0F) ).collect(Collectors.toList());
    
    @GetMapping("/")
    public List<usingGetterSetter> read(){
        return accounts;
    }
    @PostMapping("/abc")
    public String create(@RequestBody usingGetterSetter value){
        accounts.add(value);
        return value.getAccountHolder();
    }
    @GetMapping("/{number}")
    public usingGetterSetter indexposition(@PathVariable("number") int number){
        if(number>=0&&number<accounts.size()){
            return accounts.get(number);
        }
        return null;
    }
    //get the values by using account number
    @GetMapping("/accountno/{accno}")
    public usingGetterSetter index(@PathVariable("accno") long accno){
        try{
            return accounts.stream().filter(obj-> obj.getAccountNo()==accno).toList().get(0);
        }
        catch(ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            return null;
        }
    }
        //to update
        @PutMapping("/")
        public String update(@RequestBody usingGetterSetter value){
            for(int a=0;a<accounts.size();a++){
                if(accounts.get(a).getAccountNo()==value.getAccountNo()){
                    accounts.set(a,value);
                    return value.getAccountNo()+" has updated";
                }

            }
            return value.getAccountNo()+"hasnot updated";
        
    }
    @GetMapping("/balance/{value}")
        public List<usingGetterSetter> number(@PathVariable("value") int value){
            return accounts.stream().filter(obj-> obj.getAccountBalance()<=value).toList();
         }

    @GetMapping("/accname/{name}/{value}")
    public List<usingGetterSetter> number(@PathVariable("name") String name,@PathVariable("value") int value ){
           return accounts.stream()
                .filter(obj-> obj.getAccountHolder().equals(name) && obj.getAccountBalance()<=value)
                //.filter(obj-> obj.getAccountBalance()<=value)
                .collect(Collectors.toList());
    }

}



