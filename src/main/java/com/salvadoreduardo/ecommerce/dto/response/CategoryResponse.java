package com.salvadoreduardo.ecommerce.dto.response;
import com.salvadoreduardo.ecommerce.entity.Category;

public record CategoryResponse(
        Long id,
        String name,
        String description
) {
    public static CategoryResponse fromEntity(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}