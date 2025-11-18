import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;
import java.util.Random;

public class BankSimulation {

    // shared semaphores
    public static Semaphore manager = new Semaphore(1); // only 1 teller at a time
    public static Semaphore safe = new Semaphore(2);     // max 2 tellers in safe
    public static Semaphore door = new Semaphore(2);    // max 2 customers enter at a time
    public static CountDownLatch tellersReady = new CountDownLatch(3); // bank only opens after 3 tellers ready

    public static Random rand = new Random();


    public static void main(String[] args) {
        System.out.println("Bank is opening....");

        // create tellers & start teller threads
        Teller[] tellers = { new Teller(0), new Teller(1), new Teller(2) };
        for (Teller t : tellers) {
            new Thread(t).start();
        }

        // wait for tellers to be ready
        try {
            tellersReady.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Bank is open!");

        // create and start 50 customer threads
        Customer[] customers = new Customer[50];
        Thread[] customerThreads = new Thread[50];

        for (int i = 0; i < 50; i++) {
            customers[i] = new Customer(i, tellers);
            customerThreads[i] = new Thread(customers[i]);
            customerThreads[i].start();
        }

        // wait for all customers to finish
        for (int i = 0; i < 50; i++) {
            try {
                customerThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // bank closes after the customers all leave
        System.out.println("Bank is closed!");

    }
}