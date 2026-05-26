package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.CategoryRequest;
import com.salvadoreduardo.ecommerce.dto.CategoryResponse;
import com.salvadoreduardo.ecommerce.entity.Category;
import com.salvadoreduardo.ecommerce.exception.RuleException;
import com.salvadoreduardo.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = new Category(request.name(), request.description());
        return CategoryResponse.fromEntity(categoryRepository.save(category));
    }

    public Page<CategoryResponse> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(CategoryResponse::fromEntity);
    }

    public CategoryResponse getCategoryById(Long id) throws RuleException {
        return CategoryResponse.fromEntity(findCategoryById(id));
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest request) throws RuleException {
        Category category = findCategoryById(id);
        request.updateCategory(category);
        return CategoryResponse.fromEntity(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) throws RuleException {
        categoryRepository.delete(findCategoryById(id));
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("Category not found"));
    }
}