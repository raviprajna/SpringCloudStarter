package ravi.labs.microservicethree;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceThreeController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceDownFallback")
    @GetMapping("/greet")
    public ResponseEntity greet(){
        String serviceOneResponse = restTemplate.getForObject("http://micro-service-one/greet", String.class);
        String serviceTwoResponse = restTemplate.getForObject("http://micro-service-two/greet", String.class);
        return ResponseEntity.ok(serviceOneResponse + " " + serviceTwoResponse);
    }

    @HystrixCommand(fallbackMethod = "serviceDownFallback" )
    @GetMapping("/greetError")
    public ResponseEntity greetError(){
        String serviceTwoResponse = restTemplate.getForObject("http://micro-service-two/greetError", String.class);
        String serviceOneResponse = restTemplate.getForObject("http://micro-service-one/greetError", String.class);
        return ResponseEntity.ok(serviceOneResponse + " " + serviceTwoResponse);
    }

    @SuppressWarnings("unused")
    public ResponseEntity serviceDownFallback(Throwable hystrixCommand) {
        return ResponseEntity.ok("Unable to get greet message from service-one or service-two");
    }
}
