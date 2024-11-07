package com.example.demo;
//container 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan
public class myfile {
    @Bean("type1")
    public pojovariable getvariable(){
        pojovariable hema=new pojovariable();
        hema.setSkillsetname("software developer");
        hema.setSkillsetduaration(3);
        hema.setSkillsettrainer("mohammed");
        hema.setSkillsettype("backend developer");
        hema.setLocation("salem");
        return hema;
    }
    @Bean("type2")
    public pojovariable getpojovariable2(){
        pojovariable hema=new pojovariable();
        hema.setSkillsetname("java developer");
        hema.setSkillsetduaration(3);
        hema.setSkillsettrainer("mohammed");
        hema.setSkillsettype("java developer");
        hema.setLocation("salem");
        return hema;
    }
    @Bean("type3")
    public pojovariable getpojovariable3(){
        pojovariable hema=new pojovariable();
        hema.setSkillsetname("python developer");
        hema.setSkillsetduaration(3);
        hema.setSkillsettrainer("mohammed");
        hema.setSkillsettype("python developer");
        hema.setLocation("salem");
        return hema;
    }
    @Bean("type4")
    public pojovariable getpojovariable4(){
        pojovariable hema=new pojovariable();
        hema.setSkillsetname("fullstack developer");
        hema.setSkillsetduaration(3);
        hema.setSkillsettrainer("mohammed");
        hema.setSkillsettype("python developer");
        hema.setLocation("salem");
        return hema;
    }
    @Bean("type5")
    public pojovariable getpojovariable5(){
        pojovariable hema=new pojovariable();
        hema.setSkillsetname(".net developer");
        hema.setSkillsetduaration(3);
        hema.setSkillsettrainer("mohammed");
        hema.setSkillsettype("python developer");
        hema.setLocation("salem");
        return hema;
    }

}
