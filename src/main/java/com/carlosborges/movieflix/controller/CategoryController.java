package com.carlosborges.movieflix.controller;
import com.carlosborges.movieflix.entity.Category;
import com.carlosborges.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController ()
@RequiredArgsConstructor
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getByCategoryId(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);

        if(optCategory.isPresent()){
            return  optCategory.get();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteByCategoryId(@PathVariable Long id){
        categoryService.deleteCategory(id);

    }


}
