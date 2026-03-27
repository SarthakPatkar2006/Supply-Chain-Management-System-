import java.sql.*;
import java.util.Scanner;

public class ConsumerService {

    Scanner sc = new Scanner(System.in);

    public void register() {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO consumers(email,password) VALUES(?,?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Consumer registered ");
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
                    "SELECT id FROM consumers WHERE email=? AND password=?");
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

    public void searchAndOrder(int consumerId) {
        System.out.print("Enter Product Name: ");
        String pname = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM products WHERE product_name=? AND quantity>0");
            ps.setString(1, pname);
            ResultSet rs = ps.executeQuery();

            System.out.println("===== Available Products =====");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | Supplier: " +
                        rs.getInt("supplier_id") + " | Qty: " +
                        rs.getInt("quantity") + " | Location: " +
                        rs.getString("location"));
            }

            System.out.print("Enter Product ID to buy: ");
            int pid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Your Location: ");
            String loc = sc.nextLine();

            PreparedStatement check = conn.prepareStatement(
                    "SELECT quantity, location FROM products WHERE id=?");
            check.setInt(1, pid);
            ResultSet rs2 = check.executeQuery();

            if (rs2.next()) {
                String sLoc = rs2.getString("location");
                int qty = rs2.getInt("quantity");

                if (!sLoc.equalsIgnoreCase(loc)) {
                    System.out.println("Supplier does not ship to your location ");
                    return;
                }

                System.out.print("Enter Quantity: ");
                int q = sc.nextInt();
                sc.nextLine();

                if (q > qty) {
                    System.out.println("Not enough stock ");
                    return;
                }

                PreparedStatement update = conn.prepareStatement(
                        "UPDATE products SET quantity=quantity-? WHERE id=?");
                update.setInt(1, q);
                update.setInt(2, pid);
                update.executeUpdate();

                System.out.println("Order Successful ");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
