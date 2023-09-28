package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;


public class Warehouse {

   private final ArrayList<Product> products;

public Warehouse() {
   products = new ArrayList<>();
}

public void addProduct (String name, Category category, int rating){
   if(name.isEmpty()) return;
   this.products.add(new Product(name, category, rating));
}


public void editProduct(String name, Category category, int rating, String id) {
for (Product item : products) {
   if(item.getId().equals(id)) {
      item.setName(name);
      item.setCategory(category);
      item.setRating(rating);

   }
}
}
public final List<Product> getAllProducts() {
   return products;
}


}
