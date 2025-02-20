package com.tasker.email_sender.services;


import com.common.EmailSendingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailTaskConsumer {

    private EmailService emailService;

    @Autowired
    public EmailTaskConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "EMAIL_SENDING_TASKS", groupId = "email-sender-group")
    public void processEmailTask(EmailSendingDto task) {
        emailService.sendEmail(task);
    }
}