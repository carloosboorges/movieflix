package com.carlosborges.movieflix.controller;
import com.carlosborges.movieflix.controller.request.CategoryRequest;
import com.carlosborges.movieflix.controller.response.CategoryResponse;
import com.carlosborges.movieflix.entity.Category;
import com.carlosborges.movieflix.mapper.CategoryMapper;
import com.carlosborges.movieflix.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController ()
@RequiredArgsConstructor
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategory(){
        List<CategoryResponse> categories = categoryService.findAll().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();
        return ResponseEntity.ok(categories);

    }

    @PostMapping
    public ResponseEntity<CategoryResponse>  saveCategory(@Valid @RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse>getByCategoryId(@PathVariable Long id){
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
