import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entitiesEnum.OrderStatus;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = new Date();
        System.out.println("-- Enter cliente data ---");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Create password: ");
        String password = sc.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        if (password.equals(confirmPassword)) {
            System.out.print("\n --- User created sucessfully ---\n");
            String passwordHash = createHashPassword(password);
            Client client = new Client(name, email, birthDate, passwordHash);
            System.out.println("-- Enter order data ---");
            System.out.print("Status: ");
            OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());

            Order salesCar = new Order(newDate, status);

            System.out.print("\nHow many items to this order? ");
            int items = sc.nextInt();

            for(int i = 0; i < items; i++) {
                createCarSales(sc, salesCar, i);
            }
            output(client, salesCar);
        } else {
            System.out.println("Passwords do not match");
        }

        sc.close();
    }

    public static void createCarSales(Scanner sc, Order salesCar, int i) {
        System.out.println("\nEnter #" + (i + 1) + " item data: ");
        System.out.print("Product name: ");
        String productName = sc.next();
        System.out.print("Product price: ");
        double productPrice = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(productName, productPrice);
        OrderItem orderItem = new OrderItem(quantity, productPrice, product);
        salesCar.addItems(orderItem);
    }

    public static void output(Client client, Order salesCar) {
        System.out.println("\n--Sumary Order--");
        System.out.print(client);
        System.out.print(salesCar);
    }

    public static String createHashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
