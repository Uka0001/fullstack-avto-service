package com.example.autoservice.service;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface MasterService {

    Master save(Master master);

    Master update(Master master);

    BigDecimal getSalary(Master master);

    List<Order> getMastersOrders(Long masterId);

    Master findById(Long masterId);
}
