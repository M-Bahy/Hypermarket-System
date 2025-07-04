package src.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import src.abstractClasses.Product;
import src.interfaces.Expirable;
import src.interfaces.Shippable;
import src.models.Cart;
import src.models.Customer;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        if (cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty. Please add items to the cart before checking out.");
        }

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

            if (product.getQuantity() < quantity) {
                throw new IllegalArgumentException("Insufficient stock for " + product.getName() + ". Available: "
                        + product.getQuantity() + ", Requested: " + quantity);
            }

            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add((Shippable) product);
                }
            }

            if (product instanceof Expirable) {
                if (((Expirable)product).isExpired()) {
                    throw new IllegalArgumentException("Cannot purchase expired product: " + product.getName());
                 
                }
            }

            String itemDescription = quantity + "x " + product.getName();
            System.out.printf("%-25s $%9.2f%n", itemDescription, price);
            total += price;
        }
        ShippingService shippingService = new ShippingService(10.5);
        System.out.println("=====================================");
        double shippingCost = 0.0;
        if (!shippableItems.isEmpty()) {
            System.out.printf("%-25s $%9.2f%n", "Subtotal", total);
            shippingCost = shippingService.calculateShippingCost(shippableItems);
            System.out.println();
            System.out.println();
        }
        System.out.printf("%-25s $%9.2f%n", "Subtotal", total);
        System.out.printf("%-25s $%9.2f%n", "Shipping", shippingCost);
        System.out.printf("%-25s $%9.2f%n", "Amount", total + shippingCost);
        System.out.println("=====================================");
        customer.deductBalance(total + shippingCost);
        System.out.printf("%-25s $%9.2f%n", "Current Balance", customer.getBalance());
    }

}
