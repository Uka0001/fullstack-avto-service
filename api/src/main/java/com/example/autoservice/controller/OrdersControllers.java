package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.GoodRequestMapper;
import com.example.autoservice.dto.mapper.request.OrderRequestMapper;
import com.example.autoservice.dto.mapper.response.OrderResponseMapper;
import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Good;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.OrderStatus;
import com.example.autoservice.service.GoodService;
import com.example.autoservice.service.OrderService;
import com.example.autoservice.service.OwnerService;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersControllers {
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderRequestMapper orderRequestMapper;
    private final OwnerService ownerService;
    private final GoodService goodService;
    private final GoodRequestMapper goodRequestMapper;

    @PostMapping
    public OrderResponseDto add(@RequestBody OrderRequestDto dto) {
        Order order = orderService.save(orderRequestMapper.fromDto(dto));
        return orderResponseMapper.toDto(order);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@RequestBody OrderRequestDto requestDto,
                                   @PathVariable Long id) {
        Order order = orderRequestMapper.fromDto(requestDto);
        order.setId(id);
        return orderResponseMapper.toDto(orderService.save(order));
    }

    @PutMapping("/{id}/{status}")
    public OrderResponseDto updateOrderStatus(@PathVariable Long id,
                                              @PathVariable OrderStatus status) {
        Order order = orderService.getOrderById(id);
        order.setStatus(status);
        return orderResponseMapper.toDto(orderService.save(order));
    }

    @PostMapping("/{orderId}/{goodId}")
    public OrderResponseDto addGood(@RequestParam Long orderId,
                                    @RequestParam Long goodId) {
        Order order = orderService.getOrderById(orderId);
        Good good = goodService.findById(goodId);
        List<Good> goodsList = order.getGoodsList();
        goodsList.add(good);
        order.setGoodsList(goodsList);
        return orderResponseMapper.toDto(order);
    }

    @GetMapping("/cost")
    public BigDecimal getOrderCost(Long orderId) {
        return orderService.calculate(orderService.getOrderById(orderId));
    }
}
