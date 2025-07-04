package src.factories;

import java.time.LocalDate;

import src.abstractClasses.Product;
import src.models.BaseProduct;
import src.models.ExpirableProduct;
import src.models.ShippableExpirableProduct;
import src.models.ShippableProduct;

public class ProductFactory {

    public static Product createProduct(String name, double price, int quantity) {
        return new BaseProduct(name, price, quantity);
    }

    public static Product createProduct(String name, double price, int quantity, LocalDate expiryDate) {
        return new ExpirableProduct(name, price, quantity, expiryDate);
    }

    public static Product createProduct(String name, double price, int quantity, double weight) {
        return new ShippableProduct(name, price, quantity, weight);
    }

    public static Product createProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        return new ShippableExpirableProduct(name, price, quantity, expiryDate, weight);
    }

}
