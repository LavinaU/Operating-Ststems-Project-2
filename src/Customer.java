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
            BankSimulation.door.acquire(); // max 2 customers in bank
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Customer " + id + " enters bank");

        // pick a teller (round robbin)
        Teller selectedTeller = tellers[id % tellers.length];
        System.out.println("Customer " + id + " [Teller " + selectedTeller.id + "]: gives transaction (" + transactionType + ")");

        selectedTeller.serveCustomer(this);

        BankSimulation.door.release();

    }

}

