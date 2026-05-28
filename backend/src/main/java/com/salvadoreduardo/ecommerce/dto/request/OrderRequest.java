package com.salvadoreduardo.ecommerce.dto.request;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Order;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
        @NotNull(message = "Customer ID is required")
        Long customerId
) {
    public void updateOrder(Order order, Customer customer) {
        if (customer != null) order.setCustomer(customer);
    }
}