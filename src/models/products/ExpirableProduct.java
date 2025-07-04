package src.models.products;

import java.time.LocalDate;

import src.abstractClasses.Product;
import src.interfaces.Expirable;

public class ExpirableProduct extends Product implements Expirable {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        setExpiryDate(expiryDate);
    }

    @Override
    public void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be a future date, got: " + expiryDate);
        }
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

}
