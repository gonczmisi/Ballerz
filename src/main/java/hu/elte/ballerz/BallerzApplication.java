package hu.elte.ballerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BallerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(BallerzApplication.class, args);
	}

}
