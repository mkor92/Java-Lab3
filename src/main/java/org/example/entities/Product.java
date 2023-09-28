package org.example.entities;

import java.util.UUID;

public class Product {

   static String name;
    int rating;
   Category category;
  String id;


    public Product(String name, Category category, int rating) {
    this.name = name;
    this.rating = rating;
    this.category = category;
    this.id = String.valueOf(UUID.randomUUID());
    
    }

    public String getId() {
        return id;
    }
    public int getRating() {
        return rating;
    }
    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        Product.name = name;
    }
}
