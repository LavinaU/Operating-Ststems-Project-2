public class Customer implements Runnable {
    int id;
    Teller[] tellers;

    public Customer(int id, Teller[] tellers) {
        this.id = id;
        this.tellers = tellers;
    }

    @Override
    public void run() {
        enterBank();

        // pick a teller (round robbin)
        Teller selectedTeller = tellers[id % tellers.length];
        System.out.println("Customer " + id + " [Teller " + selectedTeller.id + "]: gives transaction");

        selectedTeller.serveCustomer(this);

        leaveBank();
    }

    public void enterBank() {
        System.out.println("Customer " + id + " enters bank");
    }

    public void leaveBank() {
        System.out.println("Customer " + id + " leaves bank");

    }
}

