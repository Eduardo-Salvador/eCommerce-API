package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Review;
import java.time.LocalDateTime;

public record ReviewResponse(
        Long id,
        ProductResponse product,
        CustomerResponse customer,
        Integer rating,
        String comment,
        LocalDateTime createdAt
) {
    public static ReviewResponse fromEntity(Review review) {
        return new ReviewResponse(
                review.getId(),
                ProductResponse.fromEntity(review.getProduct()),
                CustomerResponse.fromEntity(review.getCustomer()),
                review.getRating(),
                review.getComment(),
                review.getCreatedAt()
        );
    }
}