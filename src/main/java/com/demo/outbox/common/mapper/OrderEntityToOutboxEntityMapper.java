package com.demo.outbox.common.mapper;

import com.demo.outbox.entity.Order;
import com.demo.outbox.entity.Outbox;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.Date;

@Component
public class OrderEntityToOutboxEntityMapper {

    public Outbox map(Order order) {
        return Outbox.builder()
                .aggregateId(order.getId().toString())
                .payLoad(new ObjectMapper().writeValueAsString(order))
                .createdAt(new Date())
                .processed(false)
                .build();
    }
}
