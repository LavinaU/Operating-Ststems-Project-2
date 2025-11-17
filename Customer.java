public class Customer {
    int id;

    public Customer(int id) {
        this.id = id;
    }

    public void enterBank() {
        System.out.println("Customer " + id + " enters bank");
    }
}

