package com.igorfersantos.dsdeliver.dto;

import com.igorfersantos.dsdeliver.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product entity){
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageUri();
    }
}
