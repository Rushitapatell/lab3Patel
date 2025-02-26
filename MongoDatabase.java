/** Project:Database Assignment
 * Course: IST 242
 * Author:Rushita Patel
 * Date Developed:02/24/25
 * Last Date Changed:02/26/25

 */
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDatabase {
    private static final String DATABASE_NAME = "retail_store";
    private static final String COLLECTION_NAME = "customers";
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    public MongoDatabase() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
        System.out.println("Connected to MongoDB.");
    }

    public void insertCustomer(int id, String name, String email) {
        Document customer = new Document("id", id)
                .append("name", name)
                .append("email", email);
        collection.insertOne(customer);
        System.out.println("Customer inserted into MongoDB.");
    }

    public void readCustomers() {
        FindIterable<Document> customers = collection.find();
        for (Document customer : customers) {
            System.out.println("ID: " + customer.getInteger("id") + ", Name: " + customer.getString("name") +
                    ", Email: " + customer.getString("email"));
        }
    }

    public void updateCustomer(int id, String newName) {
        collection.updateOne(new Document("id", id), new Document("$set", new Document("name", newName)));
        System.out.println("Customer updated in MongoDB.");
    }

    public void deleteCustomer(int id) {
        collection.deleteOne(new Document("id", id));
        System.out.println("Customer deleted from MongoDB.");
    }

    public void close() {
        mongoClient.close();
    }
}
