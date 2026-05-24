package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Order;
import com.salvadoreduardo.ecommerce.entity.OrderItem;
import com.salvadoreduardo.ecommerce.entity.Product;
import java.math.BigDecimal;

public record OrderItemRequest(
        Long orderId,
        Long productId,
        Integer quantity,
        BigDecimal price
) {
    public void updateOrderItem(OrderItem orderItem, Order order, Product product) {
        if (order != null) orderItem.setOrder(order);
        if (product != null) orderItem.setProduct(product);
        if (quantity != null) orderItem.setQuantity(quantity);
        if (price != null) orderItem.setPrice(price);
    }
}