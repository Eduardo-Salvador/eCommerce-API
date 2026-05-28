package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.request.ProductRequest;
import com.salvadoreduardo.ecommerce.dto.response.ProductResponse;
import com.salvadoreduardo.ecommerce.entity.Category;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.exception.RuleException;
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

    public ProductResponse createProduct(ProductRequest request) throws RuleException {
        if (request.quantity() < 0) {
            throw new RuleException("Quantity cannot be negative");
        }
        if (request.price().doubleValue() < 0) {
            throw new RuleException("Price cannot be negative");
        }
        Category category = findCategoryById(request.categoryId());
        Product product = new Product(category, request.name(), request.description(), request.price(), request.quantity());
        return ProductResponse.fromEntity(productRepository.save(product));
    }

    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductResponse::fromEntity);
    }

    public ProductResponse getProductById(Long id) throws RuleException {
        return ProductResponse.fromEntity(findProductById(id));
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) throws RuleException {
        Product product = findProductById(id);
        Category category = request.categoryId() != null ? findCategoryById(request.categoryId()) : null;
        request.updateProduct(product, category);
        return ProductResponse.fromEntity(productRepository.save(product));
    }

    public void deleteProduct(Long id) throws RuleException {
        productRepository.delete(findProductById(id));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuleException("Product not found"));
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("Category not found"));
    }
}