package com.example.autoservice.service.impl;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.service.MasterService;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterServiceImpl implements MasterService {
    private MasterRepository masterRepository;

    @Override
    public Master save(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public BigDecimal getSalary(Master master) {

        Long id = master.getId();
        List<Order> completedOrder = masterRepository
                .findById(id).get().getCompletedOrder();
        completedOrder.forEach(order -> order.setStatus(OrderStatus.PAID));
        return completedOrder
                .stream()
                .map(order -> order.getTotalCost())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<Order> getMastersOrders(Long masterId) {
        //return masterRepository.findById(masterId).get().getCompletedOrder();
        return masterRepository.findAllByMasterId(masterId);
    }

    @Override
    public Master findById(Long masterId) {
        return masterRepository.findById(masterId).orElseThrow();
    }
}
