package com.vatelier.vatelier.Service;

import com.vatelier.vatelier.Entities.Category;
import com.vatelier.vatelier.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public Category saveCategory(Category category){
        categoryRepository.save(category);
        return category;
    }
    public Optional<Category> getCategoryById(int id){
        System.out.println(categoryRepository.findById(id));
        return categoryRepository.findById(id);
    }
}
