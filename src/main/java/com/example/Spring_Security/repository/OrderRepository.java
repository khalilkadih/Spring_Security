package com.example.Spring_Security.repository;

import com.example.Spring_Security.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUuid(String reference);
}
