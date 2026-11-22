package com.demo.outbox.common.mapper;

import com.demo.outbox.common.dto.OrderRequestDTO;
import com.demo.outbox.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderDtoToEntityMapper {

    public Order map(OrderRequestDTO orderRequestDTO) {
        return Order.builder()
                .customerId(orderRequestDTO.getCustomerId())
                .name(orderRequestDTO.getName())
                .productType(orderRequestDTO.getProductType())
                .quantity(orderRequestDTO.getQuantity())
                .price(orderRequestDTO.getPrice())
                .orderdate(new Date())
                .build();
    }
}
