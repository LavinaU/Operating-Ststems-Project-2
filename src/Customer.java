public class Customer implements Runnable {
    int id;
    Teller[] tellers;
    String transactionType;


    public Customer(int id, Teller[] tellers) {
        this.id = id;
        this.tellers = tellers;

        // randomly decide transaction type
        this.transactionType = BankSimulation.rand.nextBoolean() ? "Deposit" : "Withdraw" ;
    }

    @Override
    public void run() {
        try {
            // simulate wait b4 entering bank
            Thread.sleep(BankSimulation.rand.nextInt(101));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        enterBank();

        // pick a teller (round robbin)
        Teller selectedTeller = tellers[id % tellers.length];
        System.out.println("Customer " + id + " [Teller " + selectedTeller.id + "]: gives transaction");

        selectedTeller.serveCustomer(this);
    }

    public void enterBank() {
        System.out.println("Customer " + id + " enters bank");
    }

}

