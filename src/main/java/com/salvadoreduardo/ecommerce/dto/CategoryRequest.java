package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Category;

public record CategoryRequest(
        String name,
        String description
) {
    public void updateCategory(Category category) {
        if (name != null) category.setName(name);
        if (description != null) category.setDescription(description);
    }
}