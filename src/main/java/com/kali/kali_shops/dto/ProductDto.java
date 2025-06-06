package com.kali.kali_shops.dto;

import com.kali.kali_shops.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal unitPrice;
    private int inventory;
    private String description;

    private Category category;

    private List<ImageDto> images;
}
