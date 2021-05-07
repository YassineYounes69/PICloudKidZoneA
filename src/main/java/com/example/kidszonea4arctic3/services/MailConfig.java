package com.example.kidszonea4arctic3.services;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
 
@Configuration
public class MailConfig {
 
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);
 
        mailSender.setUsername("KidZonePiCloud@gmail.com");
        mailSender.setPassword("kidzonepicloud");
 
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        /*props.mailSender("mail.smtp.host", GMAIL_HOST);
        props.mailSender("mail.smtp.port", GMAIL_PORT);
        props.mailSender("mail.smtp.auth", GSMTP_AUTH_REQUIRED);
        props.mailSender("mail.smtp.user", GSMTP_AUTH_USER);
        props.mailSender("mail.smtp.password", GSMTP_AUTH_PWD);
        props.mailSender("mail.smtp.starttls.enable", GSTARTTLS_ENABLE);
        props.mailSender("mail.smtp.starttls.required", GSTARTTLS_REQUIRED);
        props.mailSender("mail.smtp.startssl.enable", GSTARTSSL_ENABLE);
        props.mailSender("mail.smtp.startssl.required", GSTARTSSL_REQUIRED);*/
        return mailSender;
    }
 
}