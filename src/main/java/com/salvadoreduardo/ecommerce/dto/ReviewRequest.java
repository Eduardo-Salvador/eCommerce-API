package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.entity.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ReviewRequest(
        @NotNull(message = "Product ID is required")
        Long productId,

        @NotNull(message = "Customer ID is required")
        Long customerId,

        @NotNull(message = "Rating is required")
        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 5, message = "Rating must be at most 5")
        Integer rating,

        String comment
) {
    public void updateReview(Review review, Product product, Customer customer) {
        if (product != null) review.setProduct(product);
        if (customer != null) review.setCustomer(customer);
        if (rating != null) review.setRating(rating);
        if (comment != null) review.setComment(comment);
    }
}