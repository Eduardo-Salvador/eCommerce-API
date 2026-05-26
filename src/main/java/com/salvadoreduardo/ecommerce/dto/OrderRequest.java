package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Order;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record OrderRequest(
        @NotNull(message = "Customer ID is required")
        Long customerId
) {
    public void updateOrder(Order order, Customer customer) {
        if (customer != null) order.setCustomer(customer);
    }
}