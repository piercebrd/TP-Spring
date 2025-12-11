package sdv.m1dev2526.tp2_advanced_broudin.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("email")
public class EmailService implements MessageService{

    @Override
    public String getMessage() {
        return "Message from EmailService";
    }
}
