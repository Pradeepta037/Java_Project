public class Cart {
    private Product[] products;
    private int count;

    public Cart(int maxSize) {
        products = new Product[maxSize];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
        } else {
            System.out.println("Cart is full!");
        }
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < count; i++) {
            if (products[i] == product) {
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--count] = null;
                return;
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public Product[] getProducts() {
        Product[] result = new Product[count];
        System.arraycopy(products, 0, result, 0, count);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(products[i].toString()).append("\n");
        }
        sb.append("Total: $").append(getTotal());
        return sb.toString();
    }
}
