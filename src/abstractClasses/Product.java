package src.abstractClasses;

public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Product name cannot be null or empty");

        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if (price <= 0)
            throw new IllegalArgumentException("Price must be positive, got: " + price);

        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative, got: " + quantity);

        this.quantity = quantity;
    }

}
