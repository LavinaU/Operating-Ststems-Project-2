import java.util.concurrent.Semaphore;

public class BankSimulation {
    public static void main(String[] args) {
        System.out.println("Bank is open!");

        // semaphore to make sure 1 customer interacts w a teller at a time
        Semaphore tellerSemaphore = new Semaphore(1);

        // create tellers
        Teller[] tellers = { new Teller(0,tellerSemaphore), new Teller(1, tellerSemaphore), new Teller(2, tellerSemaphore) };

        // create customers
        Customer[] customers = {
                new Customer(0, tellers),
                new Customer(1, tellers),
                new Customer(2, tellers)
        };

        // start customer threads
        for (Customer c : customers) {
            new Thread(c).start();
        }

        // waiting for all customers to fin introducing themselves
        try{
            Thread.sleep(2000); // need to adj as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Bank is closed!");
    }
}