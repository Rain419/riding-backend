package com.soa.emergencyservice.controller;

import com.soa.emergencyservice.config.Sender;
import com.soa.emergencyservice.dao.ContactDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: rain
 * @Date: 2023-11-06-9:54
 * @Description:
 */
class SendMessageControllerTest {

    @Mock
    private ContactDao contactDao;

    @Mock
    private Sender sender;

    @InjectMocks
    private SendMessageController sendMessageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendMessage() {
        // Arrange
        String orderId = "123456";

        // Act
        sendMessageController.sendMessage(orderId);

        // Assert
        // You can add more specific verifications based on your implementation
        verify(sender, times(1)).send(orderId);
    }
}