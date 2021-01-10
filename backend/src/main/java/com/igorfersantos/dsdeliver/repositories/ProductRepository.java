package com.igorfersantos.dsdeliver.repositories;

import com.igorfersantos.dsdeliver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByNameAsc();
}
