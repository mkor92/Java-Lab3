package org.example;


import org.example.entities.Category;
import org.example.service.Warehouse;

public class App {
    public static void main(String[] args) {

        Warehouse icaMaxi = new Warehouse();

        icaMaxi.addProduct("Hamburgare", Category.FOOD, 7);
        icaMaxi.addProduct("Korv", Category.FOOD, 7);

        System.out.println();
    }
}
