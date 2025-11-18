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
        // pick a teller (for rn first available)
        Teller selectedTeller = tellers[id % tellers.length];
        System.out.println("Customer " + id + " selects Teller " + selectedTeller.id);
        selectedTeller.introduceToCustomer(this);
    }


    public void enterBank() {
        System.out.println("Customer " + id + " enters bank");
    }
}

