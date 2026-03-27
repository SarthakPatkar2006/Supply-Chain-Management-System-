import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchElementException, InputMismatchException {
        Scanner sc = new Scanner(System.in);
        SupplierService supplier = new SupplierService();
        ConsumerService consumer = new ConsumerService();
        int choice;

        while (true) {
            System.out.println("\n===== SUPPLY CHAIN MANAGEMENT SYSTEM =====");
            System.out.println("1. Supplier Register");
            System.out.println("2. Supplier Login");
            System.out.println("3. Consumer Register");
            System.out.println("4. Consumer Login");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            if (choice == 1) {
                supplier.register();
            }
            else if (choice == 2) {
                int id = supplier.login();
                if (id != -1) {
                    while (true) {
                        System.out.println("\n1. Add Product");
                        System.out.println("2. View All Products");
                        System.out.println("3. Logout");
                        System.out.print("Choose: ");
                        int ch = sc.nextInt();

                        if (ch == 1) supplier.addProduct(id);
                        else if (ch == 2) supplier.viewProducts(id);
                        else break;
                    }
                }
            }
            else if (choice == 3) {
                consumer.register();
            }
            else if (choice == 4) {
                int id = consumer.login();
                if (id != -1) {
                    while (true) {
                        System.out.println("\n1. Search Product & Order");
                        System.out.println("2. Logout");
                        System.out.print("Choose: ");
                        int ch = sc.nextInt();

                        if (ch == 1) consumer.searchAndOrder(id);
                        else break;
                    }
                }
            }
            else {
                System.out.println("Thank you!");
                break;
            }
        }

        sc.close();
    }
}
