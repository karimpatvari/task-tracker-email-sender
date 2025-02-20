package com.tasker.email_sender.services;


import com.common.EmailSendingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${sender.email}")
    private String SENDER_EMAIL;
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(EmailSendingDto task) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER_EMAIL);
        message.setTo(task.getRecipient());
        message.setText(task.getBody());
        message.setSubject(task.getSubject());

        javaMailSender.send(message);
    }
}

//    private final String SENDER_EMAIL = "tasker.spring@gmail.com";
