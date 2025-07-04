package src.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import src.abstractClasses.Product;
import src.interfaces.Shippable;

public class ShippingService {

    private double shippingRate ;

    public ShippingService(double shippingRate) {
        setShippingRate(shippingRate);
    }

    public double calculateShippingCost(List<Shippable> shippableItems) {
        HashMap<Shippable, Integer> itemCounts = new HashMap<>();
        double totalWeight = 0.0;
        for (Shippable item : shippableItems) {
            totalWeight += item.getWeight();
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        System.out.println("** Shipment Notice **");
        System.out.println("=====================================");
        System.out.printf("%-25s %10s%n", "Item", "Weight");
        System.out.println("=====================================");

        for (Entry<Shippable, Integer> entry : itemCounts.entrySet()) {
            Shippable product = entry.getKey();
            int quantity = entry.getValue();
            double weight = product.getWeight() * quantity;

            String itemDescription = quantity + "x " + product.getName();
            System.out.printf("%-25s %8.0fg%n", itemDescription, weight);
        }

        System.out.println("=====================================");
        System.out.printf("%-25s %7.1fkg%n", "Total package weight", totalWeight / 1000);
        System.out.println("=====================================");

        return (totalWeight / 1000) * shippingRate; // Convert grams to kg and apply rate
    }

    public double getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(double shippingRate) {
        if (shippingRate <= 0) {
            throw new IllegalArgumentException("Shipping rate must be positive, got: " + shippingRate);
        }
        this.shippingRate = shippingRate;
    }
}
