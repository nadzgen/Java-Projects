package finalProject; // Defines the package where the classes reside.
import static org.junit.Assert.*; // Imports all static methods from Assert class (e.g., assertEquals, assertTrue).
import org.junit.Before; // Imports the @Before annotation used for setup methods.
import java.util.List; // Imports the List interface for working with lists.

import org.junit.Test; // Imports the @Test annotation used to mark test methods.

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


class JUnitTest { // Defines the test class.

    // Inner class to test the functionality of the Inventory class
    class InventoryTest { 
        private Inventory inventory; // Declare an Inventory object to be used in tests.

        // This method will run before each test to set up the initial state.
        @Before // Indicates that this method should run before each test method.
        void setUp() {
            inventory = new Inventory(); // Initialize the Inventory object.
            
            // Add sample products to the inventory for testing purposes.
            inventory.addProduct("Milk", "2024-12-01");
            inventory.addProduct("Bread", "2024-12-05");
            inventory.addProduct("Cheese", "2024-11-30");
            inventory.addProduct("Orange Juice", "2024-12-25");
            inventory.addProduct("Milo", "2025-01-01");
            inventory.addProduct("Palapa", "2024-11-24");
            inventory.addProduct("Banana Ketchup", "2024-12-12");
        }

        // Test the functionality of adding a product to the inventory.
        @Test // Marks this method as a test case.
        void testAddProduct() {
            inventory.addProduct("Eggs", "2024-12-10"); // Add a new product to the inventory.

            // Verify that the size of the product list is now 8.
            assertEquals(8, inventory.products.size()); 

            // Verify that the last product in the list is "Eggs".
            assertEquals("Eggs", inventory.products.get(7).getName());

            // Verify that the expiration date of the newly added product is "2024-12-10".
            assertEquals("2024-12-10", inventory.products.get(7).getExpirationDate());
        }

        // Test the functionality of checking for expired products.
        @Test // Marks this method as a test case.
        void testCheckExpiredProducts() {
            // Get the list of expired products as of "2024-12-07".
            List<Product> expiredProducts = inventory.checkExpiredProducts("2024-12-07");

            // Verify that the number of expired products is 4.
            assertEquals(4, expiredProducts.size());

            // Check if "Cheese" is in the list of expired products.
            assertTrue(expiredProducts.stream().anyMatch(p -> p.getName().equals("Cheese")));

            // Check if "Palapa" is in the list of expired products.
            assertTrue(expiredProducts.stream().anyMatch(p -> p.getName().equals("Palapa")));

            // Check if "Milk" is in the list of expired products.
            assertTrue(expiredProducts.stream().anyMatch(p -> p.getName().equals("Milk")));

            // Check if "Bread" is in the list of expired products.
            assertTrue(expiredProducts.stream().anyMatch(p -> p.getName().equals("Bread")));
        }

        // Test the functionality of sorting products by expiration date.
        @Test // Marks this method as a test case.
        void testSortProductsByExpiration() {
            inventory.sortProductsByExpiration(); // Sort the products by expiration date.

            // Verify that the product at index 0 is "Palapa".
            assertEquals("Palapa", inventory.products.get(0).getName());

            // Verify that the product at index 1 is "Cheese".
            assertEquals("Cheese", inventory.products.get(1).getName());

            // Verify that the product at index 2 is "Milk".
            assertEquals("Milk", inventory.products.get(2).getName());

            // Verify that the product at index 3 is "Bread".
            assertEquals("Bread", inventory.products.get(3).getName());

            // Verify that the product at index 4 is "Banana Ketchup".
            assertEquals("Banana Ketchup", inventory.products.get(4).getName());

            // Verify that the product at index 5 is "Orange Juice".
            assertEquals("Orange Juice", inventory.products.get(5).getName());

            // Verify that the product at index 6 is "Milo".
            assertEquals("Milo", inventory.products.get(6).getName());
        }
    }
}





