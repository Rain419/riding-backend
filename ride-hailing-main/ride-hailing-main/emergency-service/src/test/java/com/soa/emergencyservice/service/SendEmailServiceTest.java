package com.soa.emergencyservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: rain
 * @Date: 2023-11-06-9:52
 * @Description:
 */
class SendEmailServiceTest {
    @InjectMocks
    private SendEmailService sendEmailService;
    @Mock
    private JavaMailSender mailSender;

    @Mock
    private Logger logger;

    @BeforeEach  // important can not forget
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void sendSimpleMail() {
        // Arrange
        String toMail = "recipient@example.com";
        String subject = "Test Subject";
        String content = "Test Content";

        SimpleMailMessage expectedMailMessage = new SimpleMailMessage();
        expectedMailMessage.setFrom("your@mail.com");
        expectedMailMessage.setTo(toMail);
        expectedMailMessage.setSubject(subject);
        expectedMailMessage.setText(content);

        // Act
        sendEmailService.sendSimpleMail(toMail, subject, content);

        // Assert
        verify(mailSender, times(1)).send(expectedMailMessage);
    }
}