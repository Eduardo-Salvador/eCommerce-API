package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Category;
import com.salvadoreduardo.ecommerce.entity.Product;
import java.math.BigDecimal;

public record ProductRequest(
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
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