package io.ffn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WorkdistributionApiApplication {

	@RequestMapping("/")
	  public String home() {
	    return "Welcome Work Distribution App - API in Docker";
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(WorkdistributionApiApplication.class, args);
	}

}
