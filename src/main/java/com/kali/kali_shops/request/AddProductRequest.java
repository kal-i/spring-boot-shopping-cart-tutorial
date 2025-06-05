package com.kali.kali_shops.request;

import com.kali.kali_shops.model.Category;
import lombok.Data;

import java.math.BigDecimal;

// We create this class because it isn't available to work directly with entities or model classes
@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal unitPrice;
    private int inventory;
    private String description;
    private Category category;
}
