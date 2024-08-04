import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Laptop", 999.99);
        products[1] = new Product("Smartphone", 699.99);
        products[2] = new Product("Headphones", 199.99);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        User user = new User(userName, 10); // Cart can hold up to 10 products

        boolean running = true;
        while (running) {
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i]);
                    }
                    break;

                case 2:
                    System.out.println("Enter product number to add to cart:");
                    int productIndex = scanner.nextInt() - 1;
                    if (productIndex >= 0 && productIndex < products.length) {
                        user.addProductToCart(products[productIndex]);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 3:
                    user.viewCart();
                    break;

                case 4:
                    user.placeOrder();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
