package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.ProductRequest;
import com.salvadoreduardo.ecommerce.dto.ProductResponse;
import com.salvadoreduardo.ecommerce.entity.Category;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.repository.CategoryRepository;
import com.salvadoreduardo.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductResponse createProduct(ProductRequest request) throws IllegalArgumentException {
        if (request.quantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (request.price().doubleValue() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        Category category = findCategoryById(request.categoryId());
        Product product = new Product(category, request.name(), request.description(), request.price(), request.quantity());
        return ProductResponse.fromEntity(productRepository.save(product));
    }

    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductResponse::fromEntity);
    }

    public ProductResponse getProductById(Long id) throws IllegalArgumentException {
        return ProductResponse.fromEntity(findProductById(id));
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) throws IllegalArgumentException {
        Product product = findProductById(id);
        Category category = request.categoryId() != null ? findCategoryById(request.categoryId()) : null;
        request.updateProduct(product, category);
        return ProductResponse.fromEntity(productRepository.save(product));
    }

    public void deleteProduct(Long id) throws IllegalArgumentException {
        productRepository.delete(findProductById(id));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
}