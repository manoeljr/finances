package com.homefinances.web;

import com.homefinances.domain.model.Category;
import com.homefinances.domain.service.category.CategoryService;
import com.homefinances.web.request.category.RegisterCategoryDTO;
import com.homefinances.web.response.category.ResponseCategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/categories")
public class CategoryRestController {

    private final CategoryService service;

    public CategoryRestController(CategoryService categoryService) {
        this.service = categoryService;
    }

    @PostMapping
    public ResponseEntity<ResponseCategoryDTO> registerCategory(@RequestBody RegisterCategoryDTO category) {
        var newCategory = service.registerCategory(new Category(category.description()));
        if (newCategory != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

}
