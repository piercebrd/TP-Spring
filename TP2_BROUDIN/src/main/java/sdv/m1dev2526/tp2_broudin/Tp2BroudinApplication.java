package sdv.m1dev2526.tp2_broudin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sdv.m1dev2526.tp2_broudin.service.BavardService;

@SpringBootApplication
@RestController
public class Tp2BroudinApplication {

    private BavardService bavardService;

    @Autowired
    public Tp2BroudinApplication(BavardService bavardService) {
        this.bavardService = bavardService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp2BroudinApplication.class, args);
    }

    @GetMapping("parler")
    public String parler() {
        return bavardService.parler();
    }

}
