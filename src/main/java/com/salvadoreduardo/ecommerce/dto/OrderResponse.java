package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Order;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        CustomerResponse customer,
        BigDecimal total,
        LocalDateTime orderDate
) {
    public static OrderResponse fromEntity(Order order) {
        return new OrderResponse(
                order.getId(),
                CustomerResponse.fromEntity(order.getCustomer()),
                order.getTotal(),
                order.getOrderDate()
        );
    }
}