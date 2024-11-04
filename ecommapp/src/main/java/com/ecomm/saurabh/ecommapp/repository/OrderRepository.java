package com.ecomm.saurabh.ecommapp.repository;

import com.ecomm.saurabh.ecommapp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
