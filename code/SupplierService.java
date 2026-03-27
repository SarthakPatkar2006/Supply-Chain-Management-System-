import java.sql.*;
import java.util.Scanner;

public class SupplierService {

    Scanner sc = new Scanner(System.in);

    public void register() {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO suppliers(email,password) VALUES(?,?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Supplier registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int login() {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT id FROM suppliers WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful ");
                return rs.getInt("id");
            } else {
                System.out.println("Invalid Credentials ");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }

    public void addProduct(int supplierId) {
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO products(supplier_id,product_name,quantity,location) VALUES(?,?,?,?)");
            ps.setInt(1, supplierId);
            ps.setString(2, name);
            ps.setInt(3, qty);
            ps.setString(4, location);
            ps.executeUpdate();
            System.out.println("Product Added ");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewProducts(int supplierId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM products WHERE supplier_id=?");
            ps.setInt(1, supplierId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Your Products =====");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("product_name") + " | Qty: " +
                        rs.getInt("quantity") + " | Location: " +
                        rs.getString("location"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
