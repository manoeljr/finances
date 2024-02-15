package com.homefinances.domain.service.category;


import com.homefinances.domain.model.Category;

import java.util.List;

public interface CategoryService {
    Category registerCategory(Category category);
    void deleteCategory(Integer idCategory);
    Category searchCategoryByDescription(String description);
    List<Category> getListCategory();
    Category updateCategory(Category category);
}
