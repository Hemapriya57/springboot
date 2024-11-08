package controller.restcontroller;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// to perform crud operations using pojo file

@RestController
@RequestMapping("/get")
public class getterSetterApi {
   // List<usingGetterSetter> skills = new  ArrayList<usingGetterSetter>();
   // public getterSetterApi(){
        //skills.add(new getterSetterApi("canarabank","hema","76686876","qw09987","89997.0"));
        List<usingGetterSetter> accounts = Stream.of(new usingGetterSetter("canarabank","hema",7668688876L,"qw09987",8000.0F),
        new usingGetterSetter ("axisbank","priya",12345678L,"abc1234",4000.0F) ).collect(Collectors.toList());
    
    @GetMapping("/")
    public List<usingGetterSetter> read(){
        return accounts;
    }
    @PostMapping("/abc")
    public String create(@RequestBody usingGetterSetter value){
        accounts.add(value);
        return value.getAccountHolder() +"account has created";
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
        //update the field by using account num
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

    /*@DeleteMapping("/{indexhema}")
    public String delete(@PathVariable("indexhema") int indexhema){
        accounts.remove(indexhema);
        return usingGetterSetter.getAccountHolder()+"has removed";
    }
    */

    @DeleteMapping("/{position}")
    public String delete(@PathVariable("position") int position){
        if(position>=0 && position<accounts.size()){
            accounts.remove(position);
            return "has removed";
        }
        return "hasnot removed";
    }
    /*@PutMapping("/minbal/{accno}")
    public List<usingGetterSetter> minbal(@PathVariable("accno") int accno){
        accounts.stream().filter(obj-> obj.getAccountNo()==accno).toList().get(0);
       // for(int i=0;i<=accounts.size();i++){
        if(accounts.get(0).getAccountBalance()<=5000){
          float account = accounts.get(0).getAccountBalance() - 50.0F;
          //return accounts.getAccountBalance()-50.0F;
          
        }    
    //}
        return null;
    
    }*/
    @PutMapping("/minbal")
    public void minbal(){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountBalance()<5000){
                accounts.get(i).setAccountBalance(accounts.get(i).getAccountBalance()-50.0F);
                System.out.println("Check your balance amount!");
            }
        }
    }

    @DeleteMapping("/ifsccode/{ifsccode}")
    public String code(@PathVariable ("ifsccode") String ifsccode) {
        int oldsize = accounts.size();
        accounts=accounts.stream().filter(obj-> !obj.getIfsccode().equals(ifsccode)).toList();
        int newsize= accounts.size();
        if(oldsize == newsize)
            return ifsccode+" invalid";
        else
            return ifsccode+"account suspended";
}
/*@DeleteMapping("/task1/{ifsccocde}")
public List<usingGetterSetter> codeString(@PathVariable("ifsccode") String ifsccode){
    if(usingGetterSetter.getIfsccode() == ifsccode)
}*/

   @PutMapping("/update/{accno}/{amount}")
   public String account(@PathVariable("accno") long accno,@PathVariable("amount") float amount){
    try{
        usingGetterSetter account= accounts.stream().filter(obj-> obj.getAccountNo()==accno).toList().get(0);
        account.setAccountBalance(account.getAccountBalance()+amount);
        return "your account has updated";
    }
    catch(ArrayIndexOutOfBoundsException outOfBoundsException){
        return "Account num is not valid";
    }

   }

}



