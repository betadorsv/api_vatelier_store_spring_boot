package com.vatelier.vatelier.DTO;

import com.vatelier.vatelier.Entities.Category;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String image;
    //private int categoryId;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public int getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(int categoryId) {
//        this.categoryId = categoryId;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
