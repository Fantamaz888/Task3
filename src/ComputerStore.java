

class ComputerStore {
    private Product[] products;
    private Customer[] customers;
    private Orders[] orders;
    private int productCount = 0;
    private int customerCount;
    private int orderCount;

    public ComputerStore() {
        products = new Product[100];
        customers = new Customer[100];
        orders = new Orders[100];
        customerCount = 0;
        orderCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.out.println("Product storage is full!");
        }
    }

    public void addCustomer(Customer customer) {
        if (customerCount < customers.length) {
            customers[customerCount++] = customer;
        } else {
            System.out.println("Customer storage is full!");
        }
    }

    public void createOrder(Customer customer, Product[] orderedProducts, int[] quantities) {
        if (orderCount < orders.length) {
            for (int i = 0; i < orderedProducts.length; i++) {
                boolean productFound = false;
                for (int j = 0; j < productCount; j++) {
                    if (products[j].getId() == orderedProducts[i].getId()) {
                        productFound = true;
                        if (products[j].getStockQuantity() < quantities[i]) {
                            System.out.println("Not enough stock for product: " + orderedProducts[i].getName());
                            return;
                        }
                        break;
                    }
                }
                if (!productFound) {
                    System.out.println("Product not found: " + orderedProducts[i].getName());
                    return;
                }
            }

            Orders newOrder = new Orders(orderCount + 1, customer, orderedProducts, quantities);
            orders[orderCount++] = newOrder;
            updateStockAfterOrder(newOrder);
        } else {
            System.out.println("Order storage is full!");
        }
    }

    public void updateStockAfterOrder(Orders order) {
        Product[] orderedProducts = order.getProducts().toArray(new Product[0]);

        int[] quantities = order.getQuantities();

        for (int i = 0; i < orderedProducts.length; i++) {
            for (int j = 0; j < productCount; j++) {
                if (products[j].getId() == orderedProducts[i].getId()) {
                    int newQuantity = products[j].getStockQuantity() - quantities[i];
                    products[j].setStockQuantity(newQuantity);
                    break;
                }
            }
        }
    }

    public void changeOrderStatus(int orderId, String newStatus) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getId() == orderId) {
                orders[i].setStatus(newStatus);
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }

    public void displayProductsInCategory(String category) {
        System.out.println("Products in category '" + category + "':");
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                products[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
    }

    public void displayCustomerOrders(int customerId) {
        Customer customer = null;
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getId() == customerId) {
                customer = customers[i];
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found with ID: " + customerId);
            return;
        }

        System.out.println("Orders for customer " + customer.getFirstName() + " " + customer.getLastName() + ":");
        boolean found = false;
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getCustomer().getId() == customerId) {
                orders[i].displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No orders found for this customer.");
        }
    }
}
