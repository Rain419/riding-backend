package com.soa.emergencyservice.controller;

import com.soa.emergencyservice.entity.Contact;
import com.soa.emergencyservice.entity.RspResult;
import com.soa.emergencyservice.service.ContactService;
import com.soa.emergencyservice.service.SendEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import com.soa.emergencyservice.config.Sender;
import com.soa.emergencyservice.dao.ContactDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author: rain
 * @Date: 2023-11-06-9:54
 * @Description:
 */
class SendEmailControllerTest {


    @Mock
    private SendEmailService sendEmailService;

    @Mock
    private ContactService contactService;

    @InjectMocks
    private SendEmailController sendEmailController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendSimpleEmail() {
        // Arrange
        HttpServletRequest request = mock(HttpServletRequest.class);
        String userId = "123456";

        List<Contact> contactList = Arrays.asList(
                new Contact("email1@example.com"),
                new Contact("email2@example.com")
                // Add more contacts as needed
        );

        when(contactService.findAllByUserId(userId)).thenReturn(contactList);

        // Act
        RspResult result = sendEmailController.sendSimpleEmail(request, userId);

        // Assert
        verify(sendEmailService, times(contactList.size())).sendSimpleMail(any(), anyString(), anyString());
        assertEquals(200, result.getStatus());
        assertEquals("调用成功", result.getMsg());
    }
}