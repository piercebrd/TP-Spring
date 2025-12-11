package sdv.m1dev2526.tp1_broudin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Tp1BroudinApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp1BroudinApplication.class, args);
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }
}
