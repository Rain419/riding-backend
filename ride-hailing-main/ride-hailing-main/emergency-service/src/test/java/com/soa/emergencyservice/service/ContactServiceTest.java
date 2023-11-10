package com.soa.emergencyservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;


import com.soa.emergencyservice.dao.SecurityDao;
import com.soa.emergencyservice.entity.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: rain
 * @Date: 2023-11-06-9:53
 * @Description:
 */
class ContactServiceTest {
    @InjectMocks
    private ContactService contactService;

    @Mock
    private SecurityDao securityDao;

    @BeforeEach
    public void setup() {
        // Reset mock before each test to clear any previous interactions
        reset(securityDao);
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindAllByUserId() {
        // Arrange
        String userId = "testUserId";
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        when(securityDao.findAllByUserId(userId)).thenReturn(expectedContacts);

        // Act
        List<Contact> actualContacts = contactService.findAllByUserId(userId);

        // Assert
        assertEquals(expectedContacts, actualContacts);
    }

    @Test
    public void testFindAll_Sort() {
        // Arrange
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        when(securityDao.findAll(any(Sort.class))).thenReturn(expectedContacts);

        // Act
        List<Contact> actualContacts = contactService.findAll(Sort.by(Sort.Order.asc("name")));

        // Assert
        assertEquals(expectedContacts, actualContacts);
    }

    @Test
    public void testFindAll_Pageable() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        Page<Contact> expectedPage = new PageImpl<>(expectedContacts, pageable, 20);

        when(securityDao.findAll(pageable)).thenReturn(expectedPage);

        // Act
        Page<Contact> actualPage = contactService.findAll(pageable);

        // Assert
        assertEquals(expectedPage, actualPage);
    }

    @Test
    public void testFindAllById() {
        // Arrange
        List<Integer> ids = new LinkedList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        when(securityDao.findAllById(ids)).thenReturn(expectedContacts);

        // Act
        List<Contact> actualContacts = contactService.findAllById(ids);

        // Assert
        assertEquals(expectedContacts, actualContacts);
    }

    @Test
    public void testCount() {
        // Arrange
        when(securityDao.count()).thenReturn(5L);

        // Act
        long actualCount = contactService.count();

        // Assert
        assertEquals(5L, actualCount);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Integer idToDelete = 1;

        // Act
        contactService.deleteById(idToDelete);

        // Assert
        verify(securityDao, times(1)).deleteById(idToDelete);
    }

    @Test
    public void testDelete() {
        // Arrange
        Contact contactToDelete = new Contact();

        // Act
        contactService.delete(contactToDelete);

        // Assert
        verify(securityDao, times(1)).delete(contactToDelete);
    }

    @Test
    public void testDeleteAll() {
        // Arrange
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());

        // Act
        contactService.deleteAll(expectedContacts);

        // Assert
        verify(securityDao, times(1)).deleteAll(expectedContacts);
    }

    @Test
    public void testDeleteAllInBatch() {
        // Act
        contactService.deleteAllInBatch();

        // Assert
        verify(securityDao, times(1)).deleteAllInBatch();
    }

    @Test
    public void testSave() {
        // Arrange
        Contact contactToSave = new Contact();

        // Act
        Contact savedContact = contactService.save(contactToSave);

        // Assert
        verify(securityDao, times(1)).save(contactToSave);
        assertEquals(contactToSave, savedContact);
    }

    @Test
    public void testSaveAll() {
        // Arrange
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());

        // Act
        List<Contact> savedContacts = contactService.saveAll(expectedContacts);

        // Assert
        verify(securityDao, times(1)).saveAll(expectedContacts);
        assertEquals(expectedContacts, savedContacts);
    }

    @Test
    public void testFindById() {
        // Arrange
        Integer idToFind = 1;
        Contact expectedContact = new Contact();
        when(securityDao.findById(idToFind)).thenReturn(Optional.of(expectedContact));

        // Act
        Optional<Contact> actualContact = contactService.findById(idToFind);

        // Assert
        assertEquals(Optional.of(expectedContact), actualContact);
    }

    @Test
    public void testExistsById() {
        // Arrange
        Integer idToCheck = 1;
        when(securityDao.existsById(idToCheck)).thenReturn(true);

        // Act
        boolean exists = contactService.existsById(idToCheck);

        // Assert
        assertEquals(true, exists);
    }

    @Test
    public void testFlush() {
        // Act
        contactService.flush();

        // Assert
        verify(securityDao, times(1)).flush();
    }

    @Test
    public void testSaveAndFlush() {
        // Arrange
        Contact contactToSave = new Contact();

        // Act
        Contact savedAndFlushedContact = contactService.saveAndFlush(contactToSave);

        // Assert
        verify(securityDao, times(1)).saveAndFlush(contactToSave);
        assertEquals(contactToSave, savedAndFlushedContact);
    }

    @Test
    public void testDeleteInBatch() {
        // Arrange
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());

        // Act
        contactService.deleteInBatch(expectedContacts);

        // Assert
        verify(securityDao, times(1)).deleteInBatch(expectedContacts);
    }

    @Test
    public void testGetOne() {
        // Arrange
        Integer id = 1;
        Contact expectedContact = new Contact();
        when(securityDao.getOne(id)).thenReturn(expectedContact);

        // Act
        Contact actualContact = contactService.getOne(id);

        // Assert
        assertEquals(expectedContact, actualContact);
    }

    @Test
    public void testFindOne() {
        // Arrange
        Contact exampleContact = new Contact();
        Example<Contact> example = Example.of(exampleContact);
        Optional<Contact> expectedContact = Optional.of(new Contact());
        when(securityDao.findOne(example)).thenReturn(expectedContact);

        // Act
        Optional<Contact> actualContact = contactService.findOne(example);

        // Assert
        assertEquals(expectedContact, actualContact);
    }

    @Test
    public void testFindAllByExample() {
        // Arrange
        Contact exampleContact = new Contact();
        Example<Contact> example = Example.of(exampleContact);
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        when(securityDao.findAll(example)).thenReturn(expectedContacts);

        // Act
        List<Contact> actualContacts = contactService.findAll(example);

        // Assert
        assertEquals(expectedContacts, actualContacts);
    }

    @Test
    public void testFindAllByExample_Sort() {
        // Arrange
        Contact exampleContact = new Contact();
        Example<Contact> example = Example.of(exampleContact);
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        Sort sort = Sort.by(Sort.Order.asc("name"));
        when(securityDao.findAll(example, sort)).thenReturn(expectedContacts);

        // Act
        List<Contact> actualContacts = contactService.findAll(example, sort);

        // Assert
        assertEquals(expectedContacts, actualContacts);
    }

    @Test
    public void testFindAllByExample_Pageable() {
        // Arrange
        Contact exampleContact = new Contact();
        Example<Contact> example = Example.of(exampleContact);
        List<Contact> expectedContacts = new LinkedList<>();
        expectedContacts.add(new Contact());
        expectedContacts.add(new Contact());
        Pageable pageable = PageRequest.of(0, 10);
        when(securityDao.findAll(example, pageable)).thenReturn(new PageImpl<>(expectedContacts, pageable, 20));

        // Act
        Page<Contact> actualPage = contactService.findAll(example, pageable);

        // Assert
        assertEquals(new PageImpl<>(expectedContacts, pageable, 20), actualPage);
    }

    @Test
    public void testCountByExample() {
        // Arrange
        Contact exampleContact = new Contact();
        Example<Contact> example = Example.of(exampleContact);
        when(securityDao.count(example)).thenReturn(5L);

        // Act
        long count = contactService.count(example);

        // Assert
        assertEquals(5L, count);
    }

    @Test
    public void testExistsByExample() {
        // Arrange
        Contact exampleContact = new Contact();
        Example<Contact> example = Example.of(exampleContact);
        when(securityDao.exists(example)).thenReturn(true);

        // Act
        boolean exists = contactService.exists(example);

        // Assert
        assertEquals(true, exists);
    }
}