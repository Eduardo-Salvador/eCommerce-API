package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.OrderItem;
import java.math.BigDecimal;

public record OrderItemResponse(
        Long id,
        OrderResponse order,
        ProductResponse product,
        Integer quantity,
        BigDecimal price
) {
    public static OrderItemResponse fromEntity(OrderItem orderItem) {
        return new OrderItemResponse(
                orderItem.getId(),
                OrderResponse.fromEntity(orderItem.getOrder()),
                ProductResponse.fromEntity(orderItem.getProduct()),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }
}