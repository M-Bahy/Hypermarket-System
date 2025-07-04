package src.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import src.abstractClasses.Product;
import src.interfaces.Shippable;
import src.models.Cart;
import src.models.Customer;

public class CheckoutService {

       public static void checkout(Customer customer, Cart cart) {
        double total = 0.0;
        List<Shippable> shippableItems = new ArrayList<>();

        System.out.println("** Checkout Receipt **");
        System.out.println("=====================================");
        System.out.printf("%-25s %10s%n", "Item", "Price");
        System.out.println("=====================================");
        
        for (Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice() * quantity;
            
            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add((Shippable) product);
                }
            }

            String itemDescription = quantity + "x " + product.getName();
            System.out.printf("%-25s $%9.2f%n", itemDescription, price);
            total += price;
        }
        double shippingCost = shippableItems.isEmpty() ? 0.0 : ShippingService.calculateShippingCost(shippableItems);
        System.out.println("=====================================");
        System.out.printf("%-25s $%9.2f%n", "Subtotal", total);
        System.out.printf("%-25s $%9.2f%n", "Shipping", shippingCost);
        System.out.printf("%-25s $%9.2f%n", "Amount", total+shippingCost);
        System.out.println("=====================================");
        double newBalance = customer.getBalance() - total - shippingCost;
        System.out.printf("%-25s $%9.2f%n", "Current Balance", newBalance);
    }

}
