package com.soa.emergencyservice.vo;

import lombok.Data;

/**
 * @Author: rain
 * @Date: 2023-10-31-17:47
 * @Description:
 */
@Data
public class EmergencyContact {

    private String identity;
    private String emergency_phone;
    private String userId;
    private String toEmail;

}
