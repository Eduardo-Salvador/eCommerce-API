package com.salvadoreduardo.ecommerce.controller;
import com.salvadoreduardo.ecommerce.dto.request.ReviewRequest;
import com.salvadoreduardo.ecommerce.dto.response.ReviewResponse;
import com.salvadoreduardo.ecommerce.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@RequestBody @Valid ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @GetMapping
    public Page<ReviewResponse> getAllReviews(Pageable pageable) {
        return reviewService.getAllReviews(pageable);
    }

    @GetMapping("/{id}")
    public ReviewResponse getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse updateReview(@PathVariable Long id, @RequestBody @Valid ReviewRequest request) {
        return reviewService.updateReview(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}