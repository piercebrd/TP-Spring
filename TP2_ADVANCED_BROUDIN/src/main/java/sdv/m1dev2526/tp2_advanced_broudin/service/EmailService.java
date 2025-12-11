package sdv.m1dev2526.tp2_advanced_broudin.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailService implements MessageService{

    @Override
    public String getMessage() {
        return "Message from EmailService";
    }
}
