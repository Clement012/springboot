# springboot syntax/@Annoation
 - @Controller
 - @ResponseBody
 - BEFORE CLASS^
 - @GetMapping
 - @PathVariable
 - @RequestParam
 - 
 - @ComponentScan: Before application starts, 
 - 1. scan all javaclass 
 -  ->(under folder on or below the class annotated @SpringBootApplication)
 -  ->annotated with @Controller, @Service, @Repository, @Configuration
 - 2. For example, CalculatorController.java (@Controller).
 -  ->Then spring will create an object for CalculatorController.class, 
 - and put it into the spring context.
 - 3. When there is a client call the API defined in CalculatorController.class, 
 - spring will the object from spring context and then call the instance method.
 - 
 - @SpringBootConfiguration

 # POM
 - DEPENDENCY 
 - devTools -> auto update
 -
 - PARENT 
# throw exception

# Static Difference?
 - Controller -> static method