package com.soa.emergencyservice.entity;

/**
 * @Author: rain
 * @Date: 2023-11-02-21:18
 * @Description:
 */
public class ContactBuilder {
    private Contact contact = new Contact();

    public ContactBuilder userId(String userId) {
        contact.setUserId(userId);
        return this;
    }

    public ContactBuilder toEmail(String toEmail) {
        contact.setToEmail(toEmail);
        return this;
    }
    public ContactBuilder emergency_phone(String emergency_phone) {
        contact.setEmergency_phone(emergency_phone);
        return this;
    }
    public ContactBuilder identity(String identity) {
        contact.setIdentity(identity);
        return this;
    }

    public Contact build() {
        return this.contact;
    }
}
