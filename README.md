# Hypermarket System

A comprehensive Java-based hypermarket management system that demonstrates object-oriented programming principles including inheritance, polymorphism, factory patterns, and interface implementations.

## 🚀 Features

- **Product Management**: Support for different types of products (Base, Expirable, Shippable, and Shippable-Expirable)
- **Shopping Cart**: Add products with quantities and manage cart contents
- **Customer Management**: Handle customer information and balance tracking
- **Checkout System**: Complete checkout process with receipt generation
- **Shipping Service**: Calculate shipping costs based on product weights
- **Expiry Validation**: Automatic validation of product expiry dates during checkout
- **Inventory Management**: Stock validation during purchase

## 🏗️ Architecture

The system follows a clean architecture with the following structure:

```
src/
├── abstractClasses/
│   └── Product.java           # Base product class
├── interfaces/
│   ├── Expirable.java         # Interface for products with expiry dates
│   └── Shippable.java         # Interface for products requiring shipping
├── models/
│   ├── Cart.java              # Shopping cart implementation
│   ├── Customer.java          # Customer entity
│   └── products/
│       ├── BaseProduct.java           # Basic product implementation
│       ├── ExpirableProduct.java      # Products with expiry dates
│       ├── ShippableProduct.java      # Products requiring shipping
│       └── ShippableExpirableProduct.java # Products with both features
├── factories/
│   └── ProductFactory.java    # Factory pattern for product creation
└── services/
    ├── CheckoutService.java   # Handles checkout process
    └── ShippingService.java   # Calculates shipping costs
```

## 🛠️ Design Patterns Used

### 1. **Abstract Factory Pattern**
- `ProductFactory` creates different types of products based on parameters
- Supports method overloading for different product configurations

### 2. **Template Method Pattern**
- `Product` abstract class defines the common structure
- Concrete implementations extend base functionality

### 4. **Interface Segregation**
- `Expirable` interface for products with expiry dates
- `Shippable` interface for products requiring shipping

## 📦 Product Types

### Base Product
- Basic product with name, price, and quantity
- Example: Clothing items (pants, shirts)

### Expirable Product
- Products with expiry dates
- Automatic expiry validation during checkout
- Example: Fruits (apples, bananas)

### Shippable Product
- Products requiring shipping with weight calculation
- Example: Electronics (laptops, TVs)

### Shippable Expirable Product
- Combines both expiry and shipping features
- Example: Dairy products (cheese, perishable goods)

## 🔧 Prerequisites

- Java 8 or higher
- Java Development Kit (JDK)

## 🚀 Getting Started

### Installation

1. Clone the repository:
```bash
git clone https://github.com/M-Bahy/Hypermarket-System.git
cd Hypermarket-System
```

2. Compile the project:
```bash
javac -cp . Main.java
```

3. Run the application:
```bash
java Main
```

### Usage Example

```java
// Create different types of products
Product pants = ProductFactory.createProduct("Pants", 300.30, 500);
Product apple = ProductFactory.createProduct("Apple", 5.25, 200, LocalDate.of(2025, 7, 9));
Product laptop = ProductFactory.createProduct("Laptop", 999.99, 15, 1500);
Product cheese = ProductFactory.createProduct("Cheese", 145.12, 2, LocalDate.of(2025, 7, 29), 400);

// Create cart and add products
Cart cart = new Cart();
cart.addProduct(pants, 2);
cart.addProduct(apple, 5);

// Create customer and checkout
Customer customer = new Customer("John Doe", 5000.00);
CheckoutService.checkout(customer, cart);
```

## 📊 Sample Output

```
** Checkout Receipt **
=====================================
Item                          Price
=====================================
2x Pants                   $ 600.60
3x T-Shirt                 $ 750.45
5x Apple                   $  26.25
10x Banana                 $  37.00
1x Laptop                  $ 999.99
1x TV                      $ 700.50
2x Cheese                  $ 290.24
2x Biscuits                $  23.98
=====================================
Subtotal                   $3429.01


** Shipment Notice **
=====================================
Item                        Weight
=====================================
1x Laptop                     1500g
1x TV                         3000g
2x Cheese                      800g
2x Biscuits                   1400g
=====================================
Total package weight          6.7kg
Subtotal                   $3429.01
Shipping                   $  70.35
Amount                     $3499.36
=====================================
Current Balance            $1500.64
```

## 🔍 Key Features Explained

### Validation
- **Product Validation**: Names cannot be null/empty, prices must be positive, quantities cannot be negative
- **Expiry Validation**: Products cannot be purchased if expired
- **Stock Validation**: Cannot purchase more items than available in stock
- **Balance Validation**: Customers cannot spend more than their available balance

### Error Handling
- Comprehensive exception handling for invalid inputs
- Clear error messages for debugging
- Validation at multiple levels (product creation, cart operations, checkout)

## 🧪 Testing

The system includes built-in assertions to verify functionality:
- Cart quantity updates when adding duplicate products
- Stock validation during checkout
- Balance deduction verification

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**M-Bahy**
- GitHub: [@M-Bahy](https://github.com/M-Bahy)
- Repository: [Hypermarket-System](https://github.com/M-Bahy/Hypermarket-System.git)

## 🙏 Acknowledgments

- Java documentation and best practices
- Object-oriented design principles
- Factory pattern implementation guidelines