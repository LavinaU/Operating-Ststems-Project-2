import java.util.concurrent.Semaphore;

public class Teller {
    int id;
    Semaphore semaphore;

    public Teller(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    public void serveCustomer(Customer c) {
        try {
            semaphore.acquire(); // only 1 customer at a time
            System.out.println("Teller " + id + "[Customer " + c.id + "]: asks for transaction");

            //simulate processing transac
            System.out.println("Teller " + id + " [Customer " + c.id + "]: processing transaction");
            Thread.sleep((long)(Math.random() * 20 + 10)); // 10-30ms sleep
            System.out.println("Teller " + id + " [Customer " + c.id + "]: transaction done");

            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

