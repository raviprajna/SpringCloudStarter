package ravi.labs.microservicetwo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTwoController {

    @GetMapping("/greet")
    public ResponseEntity greet(){
        return ResponseEntity.ok(" Hello Service Two");
    }
}
