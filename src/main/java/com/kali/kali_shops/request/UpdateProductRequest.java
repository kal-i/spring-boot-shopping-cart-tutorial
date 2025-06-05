package com.kali.kali_shops.request;

import com.kali.kali_shops.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal unitPrice;
    private int inventory;
    private String description;
    private Category category;
}
