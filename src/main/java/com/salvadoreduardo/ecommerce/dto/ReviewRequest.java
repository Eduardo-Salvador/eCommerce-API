package com.salvadoreduardo.ecommerce.dto;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.entity.Review;

public record ReviewRequest(
        Long productId,
        Long customerId,
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