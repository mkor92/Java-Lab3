package org.example.entities;


import java.time.LocalDateTime;

import java.util.UUID;

public class Product {

 String name;
    int rating;
   Category category;
  String id;
  final LocalDateTime creationDate;
  final LocalDateTime modificationDate;



    public Product(String name, Category category, int rating) {
    this.name = name;
    this.rating = rating;
    this.category = category;
    this.id = String.valueOf(UUID.randomUUID());
    this.creationDate = LocalDateTime.now();
    this.modificationDate = LocalDateTime.now();
    
    }

    public String getId() {
        return id;
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
        this.name = name;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        if (!creationDate.equals(modificationDate)) {
            return "Product: " +
                    "id=" + id +
                    ", name=" + name +
                    ", category=" + category +
                    ", rating=" + rating +
                    ", Created=" + creationDate +
                    ", Modified=" + modificationDate;
        }
        else  return "Product: " +
                "id=" + id +
                ", name=" + name +
                ", category=" + category +
                ", rating=" + rating +
                ", Created=" + creationDate;
    }
}
