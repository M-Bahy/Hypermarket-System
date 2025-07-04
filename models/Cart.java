package models;

import java.util.List;

import abstractClasses.Product;

public class Cart {
    private List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        if (item.getProduct().getQuantity() < item.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for product: " + item.getProduct().getName());
        }
        items.add(item);
    }

    public double getSubTotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        setProduct(product);
        setQuantity(quantity);
    }

    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive, got: " + quantity);
        }
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

}
