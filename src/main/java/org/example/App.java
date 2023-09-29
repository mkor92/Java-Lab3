package org.example;


import org.example.entities.Category;
import org.example.service.Warehouse;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {

        Warehouse icaMaxi = new Warehouse();

        icaMaxi.addProduct("Hamburgare", Category.FOOD, 7);
        icaMaxi.addProduct("Korv", Category.FOOD, 7);
        icaMaxi.addProduct("Bröd", Category.FOOD, 7);
        icaMaxi.addProduct("Ajvar", Category.FOOD, 9);

        String product = icaMaxi.getAllProducts().stream().findFirst().get().getId();

        icaMaxi.editProduct("Eluttag", Category.ELECTRONICS, 5, product);
        icaMaxi.getAllProducts().forEach(System.out::println);
       /* System.out.println(icaMaxi.getOneProduct(product));
        System.out.println(icaMaxi.getProductsInCategorySortedByName(Category.FOOD));
        System.out.println(icaMaxi.getProductsFromDate(LocalDateTime.now()));*/
        System.out.println(icaMaxi.getModifiedProducts());



    }
}
