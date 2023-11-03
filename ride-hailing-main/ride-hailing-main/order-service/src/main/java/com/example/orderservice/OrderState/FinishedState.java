package com.example.orderservice.OrderState;

import com.example.orderservice.pojo.Order;

/**
 * @Author: rain
 * @Date: 2023-11-03-21:40
 * @Description:
 */
public class FinishedState implements OrderState{
    private Order order;

    @Override
    public String getPosition() {
        return order.getTo_lat().toString() + "&" + order.getTo_lon();
    }
}
