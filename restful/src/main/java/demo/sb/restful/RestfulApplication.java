package demo.sb.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		// Try to find a bean can be @Autowired to CommandLineRunner (interface)
		// bean.run(); -> one of the processes of SpringApplication.run
		SpringApplication.run(RestfulApplication.class, args);
	}

}
