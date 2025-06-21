package com.kali.kali_shops.service.cart;

import com.kali.kali_shops.dto.CartDto;
import com.kali.kali_shops.model.Cart;
import com.kali.kali_shops.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCartById(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart initializeNewCart(User user);
    Cart getCartByUserId(Long userId);
    CartDto convertToDto(Cart cart);
}
