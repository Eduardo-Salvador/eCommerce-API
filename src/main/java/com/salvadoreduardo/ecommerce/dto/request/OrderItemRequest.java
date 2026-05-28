package com.salvadoreduardo.ecommerce.dto.request;
import com.salvadoreduardo.ecommerce.entity.Order;
import com.salvadoreduardo.ecommerce.entity.OrderItem;
import com.salvadoreduardo.ecommerce.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItemRequest(
        @NotNull(message = "Order ID is required")
        Long orderId,

        @NotNull(message = "Product ID is required")
        Long productId,

        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        Integer quantity
) {
    public void updateOrderItem(OrderItem orderItem, Order order, Product product) {
        if (order != null) orderItem.setOrder(order);
        if (product != null) orderItem.setProduct(product);
        if (quantity != null) orderItem.setQuantity(quantity);
    }
}