package org.example;

import org.example.entities.Category;
import org.example.service.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class WarehouseTest {

    private Warehouse testWareHouse;
    @BeforeEach
    void startWareHouse() {
       testWareHouse = new Warehouse();
    }
    @Test
    void addProduct() {
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);

        assertThat(testWareHouse.getAllProducts()).isNotEmpty();
    }

    @Test
    void modifyProduct() {
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);
        String product = testWareHouse.getAllProducts().stream().findFirst().get().getId();
        testWareHouse.editProduct("Coca-cola", Category.FOOD, 9, product);

        assertThat(testWareHouse.getOneProduct(product)).get().hasFieldOrPropertyWithValue("name","Coca-cola");
    }

    @Test
    void getAllProducts() {
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);
        testWareHouse.addProduct("Coca-cola", Category.FOOD, 9);
        testWareHouse.addProduct("Outlet", Category.ELECTRONICS, 5);

        assertThat(testWareHouse.getAllProducts()).hasSize(3);
    }

    @Test
    void getProductById() {
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);
        testWareHouse.addProduct("Coca-cola", Category.FOOD, 9);
        testWareHouse.addProduct("Outlet", Category.ELECTRONICS, 5);
        String product = testWareHouse.getAllProducts().stream().findFirst().get().getId();

        assertThat(testWareHouse.getOneProduct(product)).isNotEmpty();
    }

    @Test
    void getAllProductsInCategorySortedByName(){
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);
        testWareHouse.addProduct("Faucet", Category.GARDEN, 9);
        testWareHouse.addProduct("Soil", Category.GARDEN, 5);

        assertThat(testWareHouse.getProductsInCategorySortedByName(Category.GARDEN).get(0).getName()).startsWith("F");
    }

    @Test
    void getProductsFromDate(){
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);
        testWareHouse.addProduct("Faucet", Category.GARDEN, 9);
        testWareHouse.addProduct("Soil", Category.GARDEN, 5);
        System.out.println(LocalDateTime.now());

        var date = LocalDateTime.now().minusDays(1);

        assertThat(testWareHouse.getProductsFromDate(date)).hasSize(3);

    }

    @Test
    void getAllModifiedProducts() {
        testWareHouse.addProduct("Hose", Category.GARDEN, 7);
        testWareHouse.addProduct("Coca-cola", Category.FOOD, 9);
        testWareHouse.addProduct("Outlet", Category.ELECTRONICS, 5);
        testWareHouse.addProduct("Faucet", Category.GARDEN, 9);
        testWareHouse.addProduct("Soil", Category.GARDEN, 5);


        String product = testWareHouse.getAllProducts().stream().findFirst().get().getId();
        testWareHouse.editProduct("Hamburger", Category.FOOD, 7, product);


        assertThat(testWareHouse.getModifiedProducts()).hasSize(1);

    }
}