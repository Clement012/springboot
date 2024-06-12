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
 	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		   <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>5.10.0</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-params</artifactId>
      <version>5.10.0</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.32</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest</artifactId>
    <version>2.2</version>
    <scope>test</scope>
  </dependency>
	</dependencies>
 -
 - PARENT 
# throw exception

# Static Difference?
 - Controller -> static method