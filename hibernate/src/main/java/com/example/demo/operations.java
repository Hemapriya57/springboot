package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class operations {
    @Autowired   //dependency injection
    Repositoryhema  abc;

@GetMapping("/model/{model}")
public Optional<laptop> readByPrimaryKey(@PathVariable("model") String model){
    return abc.findById(model);
}
@PostMapping("/")
public laptop create(@RequestBody laptop Laptop){
    abc.save(Laptop);
    return Laptop;
}
@GetMapping("/")
public List<laptop> read(){
      return  (List<laptop>) abc.findAll(); //findAll is an iterator 
    }
@DeleteMapping("/")
public String deleteRecord(@RequestBody laptop record){
    if(abc.findById(record.getLapmodel()).isPresent()){
        abc.delete(record);
        return record.getLapmodel()+" has removed";
    }
    else
        return record.getLapmodel()+" record not found";
}

@DeleteMapping("/{model}")
public String deleteRecordById(@PathVariable("model") String model123){
    if(abc.findById(model123).isPresent()){
        abc.deleteById(model123);
        return model123+ " has removed";
    }
    else{
        return model123+" record not found";
}
}

@GetMapping("/memoryno/{memory}")
public List<laptop> readmeLaptops(@PathVariable("memory") int memory){
    return abc.findAllByLapmemory(memory);
}

@GetMapping("/price/{amount}")
public List<laptop> readByCost(@PathVariable("amount") int amount){
    return abc.fetchAmount(amount);
}
@GetMapping("/lap")
public List<String> readmodel(){
    return abc.fetchmodel();
}

@GetMapping("/filter/{memory}/{amount}")
public List<laptop> readByValues(@PathVariable("memory") int memory,@PathVariable("amount") int amount){
    return abc.fetchData(memory, amount);
}

//alter
@PutMapping("/")
public String addcolumn(){
    return abc.published()+ "updated";
}
@PutMapping("/offer")
public String offerDiscount(){
    return abc.updatelapprice()+"lap price was reduced";
}
@PutMapping("/lenova")
public String lenovaPrice(){
    return abc.updatelenova() +"lenova was updated";
}

@DeleteMapping("/brand/{name}")
public String deleteModel(@PathVariable("name") String name){
    return abc.deleteByModel(name)+" model removed";
}


}
