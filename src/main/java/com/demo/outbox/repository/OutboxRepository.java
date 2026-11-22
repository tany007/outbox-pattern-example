package com.demo.outbox.repository;

import com.demo.outbox.entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {
}
