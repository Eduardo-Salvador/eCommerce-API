package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Customer;

import java.time.LocalDate;

public record CustomerRequest(
        String firstName,
        String lastName,
        String cpf,
        LocalDate birthDate,
        String email
) {
    public void updateCustomer(Customer customer) {
        if (firstName != null) customer.setFirstName(firstName);
        if (lastName != null) customer.setLastName(lastName);
        if (cpf != null) customer.setCpf(cpf);
        if (birthDate != null) customer.setBirthDate(birthDate);
        if (email != null) customer.setEmail(email);
    }
}