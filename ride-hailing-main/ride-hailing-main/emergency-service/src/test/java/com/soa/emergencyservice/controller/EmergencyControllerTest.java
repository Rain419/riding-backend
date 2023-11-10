package com.soa.emergencyservice.controller;

import com.soa.emergencyservice.dao.EmergencyDao;
import com.soa.emergencyservice.dao.SecurityDao;
import com.soa.emergencyservice.entity.Contact;
import com.soa.emergencyservice.vo.EmergencyContact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class EmergencyControllerTest {

    @InjectMocks
    private EmergencyController emergencyController;

    @Mock
    private EmergencyDao emergencyDao;

    @Mock
    private SecurityDao securityDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAdd() {
        // Mock data for the test
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setIdentity("Test Identity");
        emergencyContact.setEmergency_phone("1234567890");
        emergencyContact.setUserId("testUser");
        emergencyContact.setToEmail("test@example.com");

        Contact expectedContact = new Contact();
        // Set expected data for the Contact object
        expectedContact.setIdentity("Test Identity");
        expectedContact.setEmergency_phone("1234567890");
        expectedContact.setUserId("testUser");
        expectedContact.setToEmail("test@example.com");


        when(emergencyDao.save(any(Contact.class))).thenReturn(expectedContact);

        // Call the method you want to test
        Contact result = emergencyController.add(emergencyContact);

        // Verify that the result matches the expected Contact object
        assertEquals(expectedContact, result);
    }

    @Test
    void testContactList() {
        String userId = "testUser";
        List<Contact> expectedContacts = new ArrayList<>();
        // Populate the expectedContacts list with test data

        when(emergencyDao.findByUserId(userId)).thenReturn(expectedContacts);

        List<Contact> result = emergencyController.contactList(userId);
        assertEquals(expectedContacts, result);
    }

    @Test
    void testCount_emergency() {
        String userId = "testUser";
        int expectedCount = 5; // Set the expected count

        when(emergencyDao.countByUserId(userId)).thenReturn(expectedCount);
        int result = emergencyController.count_emergency(userId);
        assertEquals(expectedCount, result);
    }

    @Test
    void testDeleteEmergency() {

        Integer idToDelete = 1;

        emergencyController.deleteEmergency(idToDelete);
        verify(emergencyDao).deleteById(idToDelete);
    }

    // Add more test methods for other controller endpoints

}
