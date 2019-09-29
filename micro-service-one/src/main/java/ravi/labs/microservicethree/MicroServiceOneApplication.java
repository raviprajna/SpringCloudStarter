package ravi.labs.microservicethree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceOneApplication.class, args);
	}

}
