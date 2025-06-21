package com.kali.kali_shops.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
