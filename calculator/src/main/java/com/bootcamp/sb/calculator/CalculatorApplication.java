package com.bootcamp.sb.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// @ComponentScan   -> prepare spring context step
// 1. scan all javaclass 
//  ->(under folder on or below the class annotated @SpringBootApplication)
//  ->annotated with @Controller, @Service, @Repository, @Configuration
// 2. For example, CalculatorController.java (@Controller).
//  ->Then spring will create an object for CalculatorController.class, 
//  and put it into the spring context.
// 3. When there is a client call the API defined in CalculatorController.class, 
// spring will the object from spring context and then call the instance method.
// IN CLASS, if there is no attribute, they are SAME.
// if call same object without read, there is no problem (THREAD)
// @SpringBootConfiguration
// @EnableAutoConfiguration
public class CalculatorApplication {

	private static ApplicationContext context;

	public static ApplicationContext getContext(){
		return context;
	}

	public static void main(String[] args) {  // Print out all the context in springboot // check class/object status.
		CalculatorApplication.context = 
		  SpringApplication.run(CalculatorApplication.class, args);

			// Definition of Bean in Java:
		// - simliar to java object
		// - But bean CANNOT be explicitly created by the object behaviour
		// - Spring itself will perform component scan, and then create the bean (java object) into spring context
		// - You can just annotate @Controller, @Service, @Repository, @Configuration to indicate the above behavior

		//  new item <> bean
		//  bean ALWAYS no status.
		//  BEAN CREATION is created before server Start (at context)

		//  String[] beans = springContext.getBeanDefinitionNames(); 
		//  System.out.println(Arrays.toString(beans));
	}

}
