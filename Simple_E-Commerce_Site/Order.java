public class Order {
    private Product[] products;
    private double totalAmount;

    public Order(Product[] products) {
        this.products = products;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            if (product != null) {
                sb.append(product.toString()).append("\n");
            }
        }
        sb.append("Total Amount: $").append(totalAmount);
        return sb.toString();
    }
}
