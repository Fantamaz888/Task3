class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isLoyalCustomer;

    public Customer(int id, String firstName, String lastName, String email, boolean isLoyal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isLoyalCustomer = isLoyal;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public boolean isLoyalCustomer() { return isLoyalCustomer; }

    public void displayInfo() {
        System.out.println("Customer ID: " + id + ", Name: " + firstName + " " + lastName +
                ", Email: " + email + ", Loyal: " + isLoyalCustomer);
    }
}
