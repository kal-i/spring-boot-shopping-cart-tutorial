package com.kali.kali_shops.controller;

import com.kali.kali_shops.service.category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("{api.prefix}/categories")
public class CategoryController {
    private final ICategoryService categoryService;
}
