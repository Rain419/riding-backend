package com.example.orderservice;

import com.example.orderservice.OrderState.UnderGoingState;
import com.example.orderservice.dao.DriverMapper;
import com.example.orderservice.dao.OrderMapper;
import com.example.orderservice.dao.PassengerMapper;
import com.example.orderservice.pojo.Driver;
import com.example.orderservice.pojo.Order;
import com.example.orderservice.qo.SetOrderQO;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.DriverLocationVO;
import com.example.orderservice.vo.FinishOrderVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderServiceApplicationTests {


	@InjectMocks
	private OrderService orderService;

	@Mock
	private OrderMapper orderMapper;

	@Mock
	private PassengerMapper passengerMapper;

	@Mock
	private DriverMapper driverMapper;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSelectAll() {
		List<Order> expectedResult = orderService.selectAll();
		 when(orderMapper.findAllOrders()).thenReturn(expectedResult);
		 List<Order> result = orderService.selectAll();
		 assertEquals(expectedResult, result);
		 verify(orderMapper).findAllOrders();
	}

	@Test
	void testSetNewOrder() {
		// Add test logic here and use Mockito to verify the behavior
		// For example:
		 SetOrderQO setOrderQO = new SetOrderQO(); // create a SetOrderQO object with test data
		 setOrderQO.setPrice(123456.24);
		String result = orderService.setNewOrder(setOrderQO);
		verify(orderMapper).saveOrder(any(Order.class));
	}

	@Test
	void testFinishOrder() {

		 String order_id = "yourOrderId"; // specify an order ID
		 Order order = new Order(); // create an Order object with test data
		 when(orderMapper.findOrderById(order_id)).thenReturn(order);
		 FinishOrderVo result = orderService.finishOrder(order_id);
		// // Assert the result and verify relevant behaviors
	}

	@Test
	void testUpdateDriverLocation() {

		 String driver_id = "yourDriverId"; // specify a driver ID
		 Double lon = 0.0; // specify a longitude value
		 Double lat = 0.0; // specify a latitude value
		 when(driverMapper.findDriverById(driver_id)).thenReturn(new Driver()); // Create a Driver object with test data
		 DriverLocationVO result = orderService.findDriverLocation(driver_id);
		 // Assert the result and verify relevant behaviors
	}
}
