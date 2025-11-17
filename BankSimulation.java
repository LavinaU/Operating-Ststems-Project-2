public class BankSimulation {
    public static void main(String[] args) {
        System.out.println("Bank is open!");
        // ADD TELLERA ND CUSTOMER THREADS

        // create tellers
        Teller[] tellers = { new Teller(0), new Teller(1), new Teller(2) };

        // create customers
        Customer[] customers = { new Customer(0, tellers), new Customer(1, tellers), new Customer(2, tellers) };

        // start customer threads
        for (Customer c : customers) {
            new Thread(c).start();
        }

        // waiting for all customers to fin introducing themselves
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Bank is closed!");
    }
}
