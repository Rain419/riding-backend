package com.example.orderservice.controller;

import com.example.orderservice.pojo.Order;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.OrderDetailVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSelectAll() {
        // Mock data for the test
        List<Order> expectedOrders = new ArrayList<>();


        when(orderService.selectAll()).thenReturn(expectedOrders);


        List<Order> result = orderController.selectall();

        assertEquals(expectedOrders, result);
    }

    @Test
    void testSelectAllByUidAndState() {

        String userId = "testUser";
        int state = 1; // Set the desired state
        List<OrderDetailVo> expectedOrderDetails = new ArrayList<>();


        when(orderService.findAllByUidAndState(userId, state)).thenReturn(expectedOrderDetails);


        List<OrderDetailVo> result = orderController.selectAllByUidAndState(userId, state);


        assertEquals(expectedOrderDetails, result);
    }

    @Test
    void testSelectAllByDidAndState() {

        String driverId = "testDriver";
        int state = 2; // Set the desired state
        List<OrderDetailVo> expectedOrderDetails = new ArrayList<>();


        when(orderService.findAllByDidAndState(driverId, state)).thenReturn(expectedOrderDetails);

        List<OrderDetailVo> result = orderController.selectAllByDidAndState(driverId, state);

        assertEquals(expectedOrderDetails, result);
    }

    @Test
    void testSelectByOid() {

        String orderId = "testOrder";
        int type = 1;
        OrderDetailVo expectedOrderDetail = new OrderDetailVo();


        when(orderService.findOrderByOid(orderId, type)).thenReturn(expectedOrderDetail);

        OrderDetailVo result = orderController.selectByOid(orderId, type);

        assertEquals(expectedOrderDetail, result);
    }

    @Test
    void testSelectByUId() {

        String userId = "testUser";
        int type = 1; // Set the desired type
        List<OrderDetailVo> expectedOrderDetails = new ArrayList<>();


        when(orderService.findOrderByUid(userId, type)).thenReturn(expectedOrderDetails);

        List<OrderDetailVo> result = orderController.selectByUId(type, userId);

        // Verify
        assertEquals(expectedOrderDetails, result);
    }





}
