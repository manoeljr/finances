package com.homefinances.domain.service.category;

import com.homefinances.domain.model.Category;
import com.homefinances.domain.repository.CategoryDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO repositoy;

    public CategoryServiceImpl(CategoryDAO repositoy) {
        this.repositoy = repositoy;
    }

    @Override
    public Category registerCategory(Category category) {
        return repositoy.save(category);
    }

    @Override
    public void deleteCategory(Integer idCategory) {
        // TODO
    }

    @Override
    public Category searchCategoryByDescription(String description) {
        return repositoy.findCategoryByDescription(description);
    }

    @Override
    public List<Category> getListCategory() {
        return repositoy.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        // TODO
        return repositoy.save(category);
    }
}
