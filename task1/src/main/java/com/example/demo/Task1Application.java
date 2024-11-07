package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication

public class Task1Application {

	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(myfile.class);
		pojovariable hemapriya=context.getBean("type1",pojovariable.class);
		System.out.println(hemapriya);
		hemapriya =context.getBean("type2",pojovariable.class);
		System.out.println(hemapriya);
		hemapriya = context.getBean("type3",pojovariable.class);
		System.out.println(hemapriya);
		hemapriya = context.getBean("type4",pojovariable.class);
		System.out.println(hemapriya);
		hemapriya = context.getBean("type5",pojovariable.class);
		System.out.println(hemapriya);
		context.close();

	}

}
