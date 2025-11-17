public class Teller {
    int id;

    public Teller(int id) {
        this.id = id;
    }

    public void serveCustomer(Customer c) {
        System.out.println("Teller " + id + " serves Customer " + c.id);
    }
}

