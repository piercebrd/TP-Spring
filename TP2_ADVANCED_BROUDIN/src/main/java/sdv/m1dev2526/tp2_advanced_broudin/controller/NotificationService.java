package sdv.m1dev2526.tp2_advanced_broudin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sdv.m1dev2526.tp2_advanced_broudin.service.MessageService;

@Controller
public class NotificationService {

    private MessageService messageService;

    @Autowired
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String sendMessage() {
        return messageService.getMessage();
    }
}
