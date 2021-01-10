package com.igorfersantos.dsdeliver.services;

import com.igorfersantos.dsdeliver.dto.OrderDTO;
import com.igorfersantos.dsdeliver.dto.ProductDTO;
import com.igorfersantos.dsdeliver.entity.Order;
import com.igorfersantos.dsdeliver.entity.Product;
import com.igorfersantos.dsdeliver.repositories.OrderRepository;
import com.igorfersantos.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
    }
}
