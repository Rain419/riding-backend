package com.soa.emergencyservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue
    private Integer id;

    private String userId;

    private String toEmail;

    private String emergency_phone;

    private String identity;

    public Contact() {
    }


    public Contact(String s) {
        userId=s;
    }

}
