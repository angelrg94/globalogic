package cl.globallogic.earthquake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableCircuitBreaker
public class EarthquakeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EarthquakeApiApplication.class, args);
	}

}
