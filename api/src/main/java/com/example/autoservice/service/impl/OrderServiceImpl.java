package com.example.autoservice.service.impl;

import com.example.autoservice.model.Good;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.model.Owner;
import com.example.autoservice.repository.GoodRepository;
import com.example.autoservice.repository.OrderRepository;
import com.example.autoservice.repository.OwnerRepository;
import com.example.autoservice.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final GoodRepository goodRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByOwner(Owner owner) {
        return ownerRepository
                .findById(owner.getId())
                .get().getOrders();
    }

    @Override
    public Order updateByGood(Good good, Order order) {
        List<Good> goods = order.getGoodsList();
        goods.add(good);
        order.setGoodsList(goods);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order updatedOrder, Long updatedOrderId) {
        updatedOrder.setId(updatedOrderId);
        return orderRepository.save(updatedOrder);
    }

    @Override
    public Order updateByStatus(OrderStatus status, Long updatedOrderId) {
        Order order = orderRepository.getReferenceById(updatedOrderId);
        order.setStatus(status);
        if (status.equals(OrderStatus.COMPLETED)
                || status.equals(OrderStatus.NOT_COMPLETED)) {
            order.setDateOfAdoption(LocalDate.now());
        }
        return orderRepository.save(order);
    }

    @Override
    public BigDecimal calculate(Order order) {
        List<Good> goodsList = order.getGoodsList();
        double goodsDiscount = 1 - (goodsList.size() * 0.01);
        List<com.example.autoservice.model.Service> serviceList
                = order.getServiceList();
        double servicesDiscount = 1 - (serviceList.size() * 0.02);
        BigDecimal goodCost = goodsList
                .stream()
                .map(Good::getGoodCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(BigDecimal.valueOf(goodsDiscount));
        BigDecimal serviceCost = serviceList
                .stream()
                .map(com.example.autoservice.model.Service::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(BigDecimal.valueOf(servicesDiscount));
        if (serviceList.size() > 1
                && serviceList.stream()
                .map(service -> service.getName())
                .anyMatch(s -> s.equalsIgnoreCase("Diagnostic"))) {
            serviceCost.min(BigDecimal.valueOf(500));
        }
        return goodCost.add(serviceCost);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.getReferenceById(orderId);
    }
}
