package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;



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

public final Optional<Product> getOneProduct(String id) {
  return products.stream()
          .filter(product -> product.getId().equals(id))
          .findFirst();
}
public final List<Product> getAllProducts() {
   return products;
}

public final List<Product> getProductsInCategorySortedByName(Category category){
   return products.stream()
           .filter(product -> product.getCategory() == category)
           .sorted(Comparator.comparing(Product::getName))
           .toList();
}
public final List<Product> getProductsFromDate(LocalDateTime date) {
   return products.stream()
           .filter(product -> product.getCreationDate().isAfter(date))
           .toList();
}
public final List<Product> getModifiedProducts() {
   return products.stream()
           .filter(product -> product.toString().contains("Modified"))
           .toList();
}

}
