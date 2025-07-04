package src.models;

import java.time.LocalDate;

import src.interfaces.Shippable;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable {
    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        setWeight(weight);
    }

    @Override
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be a positive value, got: " + weight);
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
