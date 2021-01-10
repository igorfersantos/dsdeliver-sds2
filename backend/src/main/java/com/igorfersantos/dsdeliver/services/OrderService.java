package com.igorfersantos.dsdeliver.services;

import com.igorfersantos.dsdeliver.dto.OrderDTO;
import com.igorfersantos.dsdeliver.dto.ProductDTO;
import com.igorfersantos.dsdeliver.entity.Order;
import com.igorfersantos.dsdeliver.entity.OrderStatus;
import com.igorfersantos.dsdeliver.entity.Product;
import com.igorfersantos.dsdeliver.repositories.OrderRepository;
import com.igorfersantos.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
    }

    @Transactional()
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(), Instant.now(), OrderStatus.PENDING);

        for (ProductDTO p : orderDTO.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }

        order = repository.save(order);

        return new OrderDTO(order);
    }

    @Transactional()
    public OrderDTO setDelivered(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
