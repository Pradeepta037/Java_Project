public class User {
    private String name;
    private Cart cart;

    public User(String name, int cartSize) {
        this.name = name;
        this.cart = new Cart(cartSize);
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    public void placeOrder() {
        Order order = new Order(cart.getProducts());
        System.out.println("Order placed successfully!");
        System.out.println(order);
        cart = new Cart(cartSize); // Reset cart after order
    }

    public void viewCart() {
        System.out.println("Cart:");
        System.out.println(cart);
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
}
