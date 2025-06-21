package com.kali.kali_shops.service.order;

import com.kali.kali_shops.dto.OrderDto;
import com.kali.kali_shops.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
