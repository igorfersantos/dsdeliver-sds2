package com.igorfersantos.dsdeliver.services;

import com.igorfersantos.dsdeliver.dto.ProductDTO;
import com.igorfersantos.dsdeliver.entity.Product;
import com.igorfersantos.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
    }
}
