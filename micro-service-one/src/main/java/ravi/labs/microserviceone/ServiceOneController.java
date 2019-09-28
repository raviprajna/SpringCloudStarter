package ravi.labs.microserviceone;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {

    @GetMapping("/greet")
    public ResponseEntity greet(){
        return ResponseEntity.ok(" Hello Service One");
    }
}
