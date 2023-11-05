package top.wx.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: rain
 * @Date: 2023-11-03-15:13
 * @Description:
 */
@Data
public class Pay {
    private String user_id;
    private Double fee;
    private String password;
}
