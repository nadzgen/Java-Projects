package finalProject; // Defines the package where the classes reside.

import java.util.*; // Imports all classes from the java.util package (e.g., List, ArrayList).

// Inventory class to manage the list of products
public class Inventory {
   List<Product> products = new ArrayList<>(); // Creates a list to store Product objects.

   // Add a product with name and expiration date
   public void addProduct(String name, String expirationDate) {
       products.add(new Product(name, expirationDate)); // Adds a new product to the products list.
   }

   // Get a list of expired products based on the current date
   public List<Product> checkExpiredProducts(String currentDate) {
       List<Product> expiredProducts = new ArrayList<>(); // Initializes a list to store expired products.

       // Iterates over all products in the inventory
       for (Product product : products) {
           // Compare expiration date with the current date
           if (product.getExpirationDate().compareTo(currentDate) < 0) { 
               // If the product's expiration date is earlier than the current date, it's expired
               expiredProducts.add(product); // Adds the expired product to the list.
           }
       }
       return expiredProducts; // Returns the list of expired products.
   }

   // Sort products by their expiration dates in ascending order
   public void sortProductsByExpiration() {
       // Sorts the products list using a comparator that compares expiration dates
       products.sort((p1, p2) -> p1.getExpirationDate().compareTo(p2.getExpirationDate()));
   }

   // Main method to test the functionality
   public static void main(String[] args) {
       Inventory inventory = new Inventory(); // Creates an instance of the Inventory class.

       // Add sample products to the inventory
       inventory.addProduct("Milk", "2024-12-01"); // Adds "Milk" with expiration date.
       inventory.addProduct("Bread", "2024-12-05"); // Adds "Bread" with expiration date.
       inventory.addProduct("Cheese", "2024-11-30"); // Adds "Cheese" with expiration date.
       inventory.addProduct("Orange Juice", "2024-12-25"); // Adds "Orange Juice" with expiration date.
       inventory.addProduct("Milo", "2025-1-01"); // Adds "Milo" with expiration date.
       inventory.addProduct("Palapa", "2024-11-24"); // Adds "Palapa" with expiration date.
       inventory.addProduct("Banana Ketchup", "2024-12-12"); // Adds "Banana Ketchup" with expiration date.

       // Check for expired products using a sample current date
       System.out.println("Expired Products:"); // Outputs a header for expired products.
       List<Product> expired = inventory.checkExpiredProducts("2024-12-07"); // Retrieves expired products as of the given date.

       // Iterates over the list of expired products and prints their details
       for (Product p : expired) {
           System.out.println(p.getName() + " expired on " + p.getExpirationDate()); // Displays product name and expiration date.
       }

       // Sort and display products by expiration date
       inventory.sortProductsByExpiration(); // Sorts the products by expiration date.

       System.out.println("\nProducts sorted by expiration date:"); // Outputs a header for sorted products.
       // Iterates over the sorted products and prints their details
       for (Product p : inventory.products) {
           System.out.println(p.getName() + " expires on " + p.getExpirationDate()); // Displays product name and expiration date.
       }
   }
}

// Product class to store details of a single product
class Product {
   private String name; // Stores the product name.
   private String expirationDate; // Stores the expiration date in YYYY-MM-DD format.

   // Constructor to initialize product details
   public Product(String name, String expirationDate) {
       this.name = name; // Initializes the product name.
       this.expirationDate = expirationDate; // Initializes the expiration date.
   }

   // Get the name of the product
   public String getName() {
       return name; // Returns the product name.
   }

   // Get the expiration date of the product
   public String getExpirationDate() {
       return expirationDate; // Returns the expiration date.
   }
}
