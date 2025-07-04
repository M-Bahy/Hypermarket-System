import src.abstractClasses.Product;
import src.factories.ProductFactory;
import src.models.Cart;
import src.models.Customer;
import src.services.CheckoutService;

import java.time.LocalDate;

public class Main {

   
    public static void main(String[] args) {

        Product pants = ProductFactory.createProduct("Pants", 300.30, 500); // Base product
        Product shirt = ProductFactory.createProduct("T-Shirt", 250.15, 100); // Base product

        Product apple = ProductFactory.createProduct("Apple", 5.25, 200 , LocalDate.of(2025, 7, 9)); // Expirable product
        Product banana = ProductFactory.createProduct("Banana", 3.70, 50, LocalDate.of(2025, 12, 31)); // Expirable product
        
        Product laptop = ProductFactory.createProduct("Laptop", 999.99, 15,10); // Shippable product
        Product tv = ProductFactory.createProduct("TV", 700.50, 30,22); // Shippable product

        Product cheese = ProductFactory.createProduct("Cheese", 145.12, 1, LocalDate.of(2025, 7, 29), 5.5); // Shippable expirable product
        Product biscuits = ProductFactory.createProduct("Biscuits", 11.99, 8, LocalDate.of(2025, 8, 12), 2.3); // Shippable expirable product

        Cart cart = new Cart();

        cart.addProduct(pants, 2);
        cart.addProduct(shirt, 3);
        cart.addProduct(apple, 5);
        cart.addProduct(banana, 10);
        cart.addProduct(laptop, 1);
        cart.addProduct(tv, 1);
        cart.addProduct(cheese, 1);
        cart.addProduct(cheese, 1); // adding the same product again will increase the quantity
        assert cart.getItems().get(cheese) == 2 : "The quantity should have increased to 2";
        cart.addProduct(biscuits, 2);

        Customer customer = new Customer("John Doe", 500.00);

        CheckoutService.checkout(customer, cart);
    }
}
