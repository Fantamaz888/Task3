class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    public Product(int id, String name, String category, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setStockQuantity(int quantity) { this.stockQuantity = quantity; }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Category: " + category +
                ", Price: $" + price + ", Stock: " + stockQuantity);
    }
}
