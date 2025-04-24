
import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

public class ProductStreamProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1000),
            new Product("Smartphone", "Electronics", 800),
            new Product("Desk", "Furniture", 150),
            new Product("Chair", "Furniture", 120),
            new Product("Pen", "Stationery", 2),
            new Product("Notebook", "Stationery", 5)
        );

        // Group by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, items) -> {
            System.out.println(category + ": " + items.size() + " products");
        });

        // Most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        groupedByCategory.forEach((category, items) -> {
            Product maxProduct = items.stream().max(Comparator.comparing(Product::getPrice)).get();
            System.out.println(category + ": " + maxProduct.getName() + " ($" + maxProduct.getPrice() + ")");
        });

        // Average price of all products
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0);
        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
