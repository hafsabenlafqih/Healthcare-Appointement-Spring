package com.emsi.notificationservice.service;

import com.emsi.notificationservice.dto.EmailRequest;
import com.emsi.notificationservice.dto.SmsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    private final WebClient webClient;
    private final String smsApiUrl;
    private final String emailApiUrl;

    public NotificationService(
            WebClient.Builder webClientBuilder,
            @Value("${notification.sms.api-url}") String smsApiUrl,
            @Value("${notification.email.api-url}") String emailApiUrl) {

        this.webClient = webClientBuilder.build();
        this.smsApiUrl = smsApiUrl;
        this.emailApiUrl = emailApiUrl;
    }

    public void sendSms(SmsRequest request) {
        log.info("Envoi d'un SMS à {} avec le message: {}", request.getPhoneNumber(), request.getMessage());

        try {
            webClient.post()
                    .uri(smsApiUrl)
                    .bodyValue(request)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            log.info("SMS envoyé (appel WebClient simulé).");
        } catch (Exception ex) {
            log.error("Erreur lors de l'appel à l'API SMS: {}", ex.getMessage());
        }
    }

    public void sendEmail(EmailRequest request) {
        log.info("Envoi d'un Email à {} avec le sujet: {}", request.getTo(), request.getSubject());

        try {
            webClient.post()
                    .uri(emailApiUrl)
                    .bodyValue(request)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            log.info("Email envoyé (appel WebClient simulé).");
        } catch (Exception ex) {
            log.error("Erreur lors de l'appel à l'API Email: {}", ex.getMessage());
        }
    }
}
