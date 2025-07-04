package src.services;

import java.util.Map.Entry;

import src.abstractClasses.Product;
import src.models.Cart;
import src.models.Customer;

public class CheckoutService {

       public static void checkout(Customer customer, Cart cart) {
        double total = 0.0;
    
        System.out.println("** Checkout Receipt **");
        System.out.println("=====================================");
        System.out.printf("%-25s %10s%n", "Item", "Price");
        System.out.println("=====================================");
        
        for (Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice() * quantity;
    
            String itemDescription = quantity + "x " + product.getName();
            System.out.printf("%-25s $%9.2f%n", itemDescription, price);
            total += price;
        }
        
        System.out.println("=====================================");
        System.out.printf("%-25s $%9.2f%n", "Subtotal", total);
        System.out.println("=====================================");
    }

}
