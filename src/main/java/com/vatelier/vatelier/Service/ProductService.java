package com.vatelier.vatelier.Service;

import com.vatelier.vatelier.Entities.Products;
import com.vatelier.vatelier.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;

    public List<Products> getAllProduct(){
        return productsRepository.findAll();
    }
    public void addProduct(Products products){
        productsRepository.save(products);
    }
}
