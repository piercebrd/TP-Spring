package sdv.m1dev2526.tp2_advanced_broudin.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService implements MessageService {

    @Override
    public String getMessage() {
        return "Message from SMS service";
    }
}
