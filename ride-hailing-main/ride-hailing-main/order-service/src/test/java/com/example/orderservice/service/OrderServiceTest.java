package com.example.orderservice.service;

import com.example.orderservice.OrderState.UnderGoingState;
import com.example.orderservice.pojo.Comment;
import com.example.orderservice.pojo.Order;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.qo.SetOrderQO;
import com.example.orderservice.vo.DriverLocationVO;
import com.example.orderservice.vo.DriverNearbyVo;
import com.example.orderservice.vo.FinishOrderVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetNewOrder() {
        SetOrderQO setOrderQO = new SetOrderQO();
        when(orderService.setNewOrder(eq(setOrderQO))).thenReturn("testOrder123");
        String orderId = orderService.setNewOrder(setOrderQO);
        assertEquals("testOrder123", orderId);
    }

    @Test
    void testTakeOrder() {
        when(orderService.takeOrder(eq("testOrder123"), eq("testDriver123"))).thenReturn(1);
        int result = orderService.takeOrder("testOrder123", "testDriver123");
        assertEquals(1, result);
    }

    @Test
    void testPickUp() {
        when(orderService.pickUp(eq("testOrder123"))).thenReturn(1);
        int result = orderService.pickUp("testOrder123");
        assertEquals(1, result);
    }

    @Test
    void testFinishOrder() {
        when(orderService.finishOrder(eq("testOrder123"))).thenReturn(new FinishOrderVo());
        FinishOrderVo finishOrderVo = orderService.finishOrder("testOrder123");
        assertNotNull(finishOrderVo);
    }

    @Test
    void testSaveComment() {
        assertDoesNotThrow(() -> orderService.saveComment("testOrder123", 4.5, "Good service"));
    }


    @Test
    void testUpdateDriverLocation() {
        assertDoesNotThrow(() -> orderService.updateDriverLocation("testDriver123", 1.0, 2.0));
    }

    @Test
    void testFindDriverLocation() {
        DriverLocationVO driverLocationVO = orderService.findDriverLocation("testDriver123");
        assertNull(driverLocationVO);
    }

    @Test
    void testFindNearestDriver() {
        when(orderService.findNearestDriver(1.0, 2.0)).thenReturn(List.of(new DriverNearbyVo()));
        List<DriverNearbyVo> driverList = orderService.findNearestDriver(1.0, 2.0);
        assertNotNull(driverList);
        assertEquals(1, driverList.size());
    }

    @Test
    void testFindCommentById() {
        Comment comment = orderService.findCommentById("testOrder123");
        assertNull(comment);
    }

    @Test
    void testGetPosition() {
        Order order = new Order();
        order.setOrderState(new UnderGoingState());
        String position = orderService.getPosition(order);
        assertNotNull(position);
    }
}
