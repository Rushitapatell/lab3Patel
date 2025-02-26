/** Project:Database Assignment
 * Course: IST 242
 * Author:Rushita Patel
 * Date Developed:02/24/25
 * Last Date Changed:02/26/25

 */
public class MySQLDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/retail_store";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private Connection connection;

    public MySQLDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(int id, String name, String email) {
        String sql = "INSERT INTO Customer (id, name, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("Customer inserted in MySQL.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readCustomers() {
        String sql = "SELECT * FROM Customer";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, String newName) {
        String sql = "UPDATE Customer SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Customer updated in MySQL.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Customer deleted from MySQL.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
