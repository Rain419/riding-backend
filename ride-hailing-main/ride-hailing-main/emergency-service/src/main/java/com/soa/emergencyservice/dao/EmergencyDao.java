package com.soa.emergencyservice.dao;

import com.soa.emergencyservice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmergencyDao extends JpaRepository<Contact, Integer> {
    int countByUserId(String userId);
    List<Contact> findByUserId(String userId);
    List<Contact> findAll();
}
