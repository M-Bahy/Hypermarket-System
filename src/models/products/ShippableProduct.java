package src.models.products;

import src.abstractClasses.Product;
import src.interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        setWeight(weight);
    }

    public void setWeight(double weight) {
        if (weight <= 0)
            throw new IllegalArgumentException("Weight must be positive, got: " + weight);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}