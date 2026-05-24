package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Order;
import java.math.BigDecimal;

public record OrderRequest(
        Long customerId,
        BigDecimal total
) {
    public void updateOrder(Order order, Customer customer) {
        if (customer != null) order.setCustomer(customer);
        if (total != null) order.setTotal(total);
    }
}