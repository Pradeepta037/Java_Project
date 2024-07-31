class Inventory {
    private Product[] products;
    private int productCount;

    public Inventory(int size) {
        products = new Product[size];
        productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Inventory is full.");
        }
    }

    public void removeProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--productCount] = null;
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void updateStock(String name, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                products[i].setQuantity(quantity);
                System.out.println("Stock updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void generateReport() {
        System.out.println("Inventory Report:");
        for (int i = 0; i < productCount; i++) {
            products[i].display();
        }
    }
}
