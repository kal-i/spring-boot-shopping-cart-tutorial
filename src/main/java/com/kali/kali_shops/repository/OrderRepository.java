package com.kali.kali_shops.repository;

import com.kali.kali_shops.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
