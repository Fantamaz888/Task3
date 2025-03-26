import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Orders {
    private int id;
    private Customer customer;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private String orderDate;
    private String status;

    public Orders(int i, Customer customer, Product[] orderedProducts, int[] quantities) {
    }

    public void Order(int id, Customer customer, ArrayList<Product> products, ArrayList<Integer> quantities) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>(products);
        this.quantities = new ArrayList<>(quantities);
        this.orderDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.status = "New";
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public ArrayList<Product> getProducts() { return new ArrayList<>(products); }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getPrice() * quantities.get(i);
        }
        if (customer.isLoyalCustomer()) {
            total *= 0.9;
        }
        return total;
    }

    public void displayDetails() {
        System.out.println("Order ID: " + id + ", Date: " + orderDate + ", Status: " + status);
        customer.displayInfo();
        System.out.println("Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print("  ");
            products.get(i).displayInfo();
            System.out.println("    Quantity: " + quantities.get(i));
        }
        System.out.println("Total: $" + calculateTotalValue());
    }

    public int[] getQuantities() {
        return new int[0];
    }
}
