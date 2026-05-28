package com.salvadoreduardo.ecommerce.dto.response;
import com.salvadoreduardo.ecommerce.entity.Customer;
import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String firstName,
        String lastName,
        String phone,
        String email,
        boolean active,
        LocalDateTime createdAt
) {
    public static CustomerResponse fromEntity(Customer customer){
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhone(),
                customer.getEmail(),
                customer.isActive(),
                customer.getCreatedAt()
        );
    }
}