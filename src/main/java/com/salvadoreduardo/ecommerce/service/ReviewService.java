package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.ReviewRequest;
import com.salvadoreduardo.ecommerce.dto.ReviewResponse;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.entity.Review;
import com.salvadoreduardo.ecommerce.exception.RuleException;
import com.salvadoreduardo.ecommerce.repository.CustomerRepository;
import com.salvadoreduardo.ecommerce.repository.ProductRepository;
import com.salvadoreduardo.ecommerce.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ReviewResponse createReview(ReviewRequest request) throws RuleException {
        if (request.rating() < 1 || request.rating() > 5) {
            throw new RuleException("Rating must be between 1 and 5");
        }
        Product product = findProductById(request.productId());
        Customer customer = findCustomerById(request.customerId());
        Review review = new Review(product, customer, request.rating(), request.comment());
        return ReviewResponse.fromEntity(reviewRepository.save(review));
    }

    public Page<ReviewResponse> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable).map(ReviewResponse::fromEntity);
    }

    public ReviewResponse getReviewById(Long id) throws RuleException {
        return ReviewResponse.fromEntity(findReviewById(id));
    }

    public ReviewResponse updateReview(Long id, ReviewRequest request) throws RuleException {
        Review review = findReviewById(id);
        Product product = request.productId() != null ? findProductById(request.productId()) : null;
        Customer customer = request.customerId() != null ? findCustomerById(request.customerId()) : null;
        request.updateReview(review, product, customer);
        return ReviewResponse.fromEntity(reviewRepository.save(review));
    }

    public void deleteReview(Long id) throws RuleException {
        reviewRepository.delete(findReviewById(id));
    }

    private Review findReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuleException("Review not found"));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuleException("Product not found"));
    }

    private Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuleException("Customer not found"));
    }
}