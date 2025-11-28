package com.emsi.notificationservice.web;

import com.emsi.notificationservice.dto.EmailRequest;
import com.emsi.notificationservice.dto.SmsRequest;
import com.emsi.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Version simple : on passe les paramètres dans l'URL
    @PostMapping("/sms")
    public ResponseEntity<String> sendSms(
            @RequestParam String phoneNumber,
            @RequestParam String message
    ) {
        SmsRequest smsRequest = new SmsRequest(phoneNumber, message);
        notificationService.sendSms(smsRequest);
        return ResponseEntity.ok("SMS envoyé (simulation).");
    }

    // On laisse l'email avec un body JSON si tu veux le tester plus tard
    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        notificationService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email envoyé (simulation).");
    }
}
