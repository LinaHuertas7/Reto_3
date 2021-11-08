package com_reto3_ciclo3.reto3.controller;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Category;
import com_reto3_ciclo3.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/all")
    public ResponseEntity<?> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findCategoryById(@PathVariable Integer id) throws ResourceNotFound {
        Category category = categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    //POST REQUEST
    @PostMapping("/save")
    public ResponseEntity<Category> registrerCategory(@RequestBody Category c){
        Category category = categoryService.saveCategory(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
