package com.vatelier.vatelier.Controller;

import com.vatelier.vatelier.Entities.Category;
import com.vatelier.vatelier.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryCotroller {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
         List<Category>  category= categoryService.getAllCategory();
         return ResponseEntity.ok(category);
    }
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        try {
           Category category1 = categoryService.saveCategory(category);
            return category1;
        }
        catch (Exception e){
            System.out.println(e);
        }
    return null;
    }
}
