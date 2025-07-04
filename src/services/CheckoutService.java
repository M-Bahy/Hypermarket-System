package src.services;

import java.util.Map.Entry;

import src.abstractClasses.Product;
import src.models.Cart;
import src.models.Customer;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        double total = 0.0;

        System.out.println("** Checkout receipt **");
        for (Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice() * quantity;

            System.out.println(quantity + "x " + product.getName() + "\t" + price);
            total += price;
        }
        System.out.println("------------------------");
        System.out.println("Subtotal\t" + total);
    }

}
