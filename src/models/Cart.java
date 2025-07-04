package src.models;

import java.util.HashMap;
import java.util.List;

import src.abstractClasses.Product;

public class Cart {
   

    private HashMap<Product, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public double subTotal() {
        double total = 0.0;
        for (Product product : items.keySet()) {
            total += product.getPrice() * items.get(product);
        }
        return total;
    }
}

