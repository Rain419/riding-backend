package com.example.orderservice.OrderState;

import com.example.orderservice.pojo.Order;

/**
 * @Author: rain
 * @Date: 2023-11-03-21:40
 * @Description:
 */
public class UnderGoingState implements OrderState{
    private Order order;

    @Override
    public String getPosition() {
        //命令客户端调用google 接口， 获取实时位置
        return "UseRealTimeMapInterface";
    }
}
