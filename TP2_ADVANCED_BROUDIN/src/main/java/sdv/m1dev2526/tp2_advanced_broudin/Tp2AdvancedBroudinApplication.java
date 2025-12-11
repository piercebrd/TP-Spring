package sdv.m1dev2526.tp2_advanced_broudin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sdv.m1dev2526.tp2_advanced_broudin.controller.NotificationService;

@SpringBootApplication
@RestController
public class Tp2AdvancedBroudinApplication {

    private NotificationService notificationService;

    @Autowired
    public Tp2AdvancedBroudinApplication(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp2AdvancedBroudinApplication.class, args);
    }

    @GetMapping("notif")
    public String notif() {
        return notificationService.sendMessage();
    }

}
