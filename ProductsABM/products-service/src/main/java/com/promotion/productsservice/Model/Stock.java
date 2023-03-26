package com.promotion.productsservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private UUID id;
    private Integer quantity;
    private UUID idProduct;
}