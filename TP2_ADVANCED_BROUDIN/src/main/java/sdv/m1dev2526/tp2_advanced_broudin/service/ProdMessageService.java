package sdv.m1dev2526.tp2_advanced_broudin.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "Vous êtes sur le profil prod";
    }
}
