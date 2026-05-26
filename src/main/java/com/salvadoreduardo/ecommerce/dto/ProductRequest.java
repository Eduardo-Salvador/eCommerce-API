package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Category;
import com.salvadoreduardo.ecommerce.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(
        @NotNull(message = "Category ID is required")
        Long categoryId,

        @NotNull(message = "Product name is required")
        @Size(min = 1, max = 255, message = "Product name must be between 1 and 255 characters")
        String name,

        String description,

        @NotNull(message = "Product price is required")
        @Min(value = 0, message = "Price must be non-negative")
        BigDecimal price,

        @NotNull(message = "Product quantity is required")
        @Min(value = 0, message = "Quantity must be non-negative")
        Integer quantity
) {
    public void updateProduct(Product product, Category category) {
        if (category != null) product.setCategory(category);
        if (name != null) product.setName(name);
        if (description != null) product.setDescription(description);
        if (price != null) product.setPrice(price);
        if (quantity != null) product.setQuantity(quantity);
    }
}