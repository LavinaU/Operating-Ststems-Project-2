public class Teller {
    int id;

    public Teller(int id) {
        this.id = id;
    }

    public void introduceToCustomer(Customer c) {
        System.out.println("Teller " + id + " SAYS HELLO TO Customer " + c.id);
    }
}

