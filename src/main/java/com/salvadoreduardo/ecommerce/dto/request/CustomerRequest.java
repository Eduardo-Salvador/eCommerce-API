package com.salvadoreduardo.ecommerce.dto.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.salvadoreduardo.ecommerce.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CustomerRequest(
        @NotNull(message = "First name is required")
        @Size(min = 1, max = 255, message = "First name must be between 1 and 255 characters")
        String firstName,

        @NotNull(message = "Last name is required")
        @Size(min = 1, max = 255, message = "Last name must be between 1 and 255 characters")
        String lastName,

        @NotNull(message = "CPF is required")
        @Size(min = 11, max = 14, message = "CPF must be between 11 (Only numbers) or 14 characters (-, .)")
        String cpf,

        @NotNull(message = "Birth date is required")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate,

        @NotNull(message = "Phone number is required")
        @Size(min = 10, max = 20, message = "Phone number must be between 10 and 20 characters")
        String phone,

        @Email(message = "Email is required or invalid")
        String email
) {
    public void updateCustomer(Customer customer) {
        if (firstName != null) customer.setFirstName(firstName);
        if (lastName != null) customer.setLastName(lastName);
        if (cpf != null) customer.setCpf(cpf);
        if (birthDate != null) customer.setBirthDate(birthDate);
        if (phone != null) customer.setPhone(phone);
        if (email != null) customer.setEmail(email);
    }
}