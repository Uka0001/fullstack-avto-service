package com.example.autoservice.service;

import com.example.autoservice.model.Good;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.model.Owner;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> getOrdersByOwner(Owner owner);

    Order updateByGood(Good good, Order order);

    Order update(Order order, Long updatedOrderId);

    Order updateByStatus(OrderStatus status, Long updatedOrderId);

    BigDecimal calculate(Order order);

    Order getOrderById(Long orderId);
}
