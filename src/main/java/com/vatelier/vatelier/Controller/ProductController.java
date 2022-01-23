package com.vatelier.vatelier.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.vatelier.vatelier.DTO.ProductDTO;
import com.vatelier.vatelier.Entities.Products;
import com.vatelier.vatelier.Service.CategoryService;
import com.vatelier.vatelier.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    protected CategoryService categoryService;
    Gson g = new Gson();
    public static String uploadDir=System.getProperty("user.dir") + "/src/main/resources/static/productImages";


    @GetMapping("/get-all")
    public List<Products> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/add")
    public  ResponseEntity<?> addProduct(@RequestParam("product") String productJson,
                                         @RequestParam("image")MultipartFile file) throws IOException {
        ProductDTO productDTO = g.fromJson(productJson, ProductDTO.class);
        Products products=new Products();
        //products.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        products.setTitle(productDTO.getTitle());
        products.setPrice(productDTO.getPrice());
        products.setDescription(productDTO.getDescription());
        String imagePath="/src/main/resources/static/productImages/"+file.getOriginalFilename();
        if(!file.isEmpty()){
            File myFile= new File(uploadDir+file.getOriginalFilename());
            myFile.createNewFile();
            FileOutputStream fos=new FileOutputStream(myFile);
            fos.write(file.getBytes());
            fos.close();
        }
        else{
            imagePath=null;
        }
            products.setImage(imagePath);
           productService.addProduct(products);
           return ResponseEntity.ok(products);

    }

}
