/** Project:Database Assignment
 * Course: IST 242
 * Author:Rushita Patel
 * Date Developed:02/24/25
 * Last Date Changed:02/26/25

 */
public class Main {
    public static void main(String[] args) {
        // Initialize database connections
        MySQLDatabase mySQLDB = new MySQLDatabase();
        MongoDatabase mongoDB = new MongoDatabase();

        // Create three Customer objects
        Customer customer1 = new Customer(1, "Alice Johnson", "alice@example.com", "123-456-7890", "123 Maple St");
        Customer customer2 = new Customer(2, "Bob Smith", "bob@example.com", "987-654-3210", "456 Oak St");
        Customer customer3 = new Customer(3, "Charlie Davis", "charlie@example.com", "555-666-7777", "789 Pine St");

        // --- Insert Customers into both databases ---
        System.out.println("\nInserting customers into MySQL and MongoDB...");
        mySQLDB.insertCustomer(customer1.getId(), customer1.getName(), customer1.getEmail());
        mySQLDB.insertCustomer(customer2.getId(), customer2.getName(), customer2.getEmail());
        mySQLDB.insertCustomer(customer3.getId(), customer3.getName(), customer3.getEmail());

        mongoDB.insertCustomer(customer1.getId(), customer1.getName(), customer1.getEmail());
        mongoDB.insertCustomer(customer2.getId(), customer2.getName(), customer2.getEmail());
        mongoDB.insertCustomer(customer3.getId(), customer3.getName(), customer3.getEmail());

        // --- Read Customers from both databases ---
        System.out.println("\nReading customers from MySQL:");
        mySQLDB.readCustomers();

        System.out.println("\nReading customers from MongoDB:");
        mongoDB.readCustomers();

        // --- Update a customer in both databases ---
        System.out.println("\nUpdating Customer 2 (Bob Smith -> Robert Smith) in MySQL and MongoDB...");
        mySQLDB.updateCustomer(2, "Robert Smith");
        mongoDB.updateCustomer(2, "Robert Smith");

        // --- Read updated data ---
        System.out.println("\nReading updated customers from MySQL:");
        mySQLDB.readCustomers();

        System.out.println("\nReading updated customers from MongoDB:");
        mongoDB.readCustomers();

        // --- Delete a customer from both databases ---
        System.out.println("\nDeleting Customer 3 (Charlie Davis) from MySQL and MongoDB...");
        mySQLDB.deleteCustomer(3);
        mongoDB.deleteCustomer(3);

        // --- Read final data after deletion ---
        System.out.println("\nReading final customers from MySQL:");
        mySQLDB.readCustomers();

        System.out.println("\nReading final customers from MongoDB:");
        mongoDB.readCustomers();

        // Close database connections
        mySQLDB.close();
        mongoDB.close();

        System.out.println("\nAll CRUD operations completed successfully!");
    }
}
