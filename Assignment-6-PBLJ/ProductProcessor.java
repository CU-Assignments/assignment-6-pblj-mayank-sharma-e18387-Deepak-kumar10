
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Comparator;

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

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1000),
            new Product("TV", "Electronics", 1500),
            new Product("Chair", "Furniture", 200),
            new Product("Table", "Furniture", 300),
            new Product("Fridge", "Appliances", 800)
        );

        // Group by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Grouped by category: " + grouped);

        // Most expensive product in each category
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        System.out.println("Most expensive product in each category: " + mostExpensive);

        // Average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("Average price of all products: " + avgPrice);
    }
}
