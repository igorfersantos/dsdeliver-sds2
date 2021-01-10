package com.igorfersantos.dsdeliver.repositories;

import com.igorfersantos.dsdeliver.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
