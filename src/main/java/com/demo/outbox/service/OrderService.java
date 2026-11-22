package com.demo.outbox.service;

import com.demo.outbox.common.dto.OrderRequestDTO;
import com.demo.outbox.common.mapper.OrderDtoToEntityMapper;
import com.demo.outbox.common.mapper.OrderEntityToOutboxEntityMapper;
import com.demo.outbox.entity.Order;
import com.demo.outbox.entity.Outbox;
import com.demo.outbox.repository.OrderRepository;
import com.demo.outbox.repository.OutboxRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDtoToEntityMapper orderDtoToEntityMapper;

    @Autowired
    private OrderEntityToOutboxEntityMapper orderEntityToOutboxEntityMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OutboxRepository outboxRepository;

    @Transactional
    public Order createOrder(OrderRequestDTO orderRequestDTO) {

        Order order = orderDtoToEntityMapper.map(orderRequestDTO);
        order = orderRepository.save(order);

        Outbox outbox = orderEntityToOutboxEntityMapper.map(order);
        outboxRepository.save(outbox);

        return order;
    }
}
