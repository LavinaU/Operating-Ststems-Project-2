import java.util.concurrent.Semaphore;
import java.util.Random;

public class BankSimulation {

    // shared semaphores
    public static Semaphore manager = new Semaphore(1); // only 1 teller at a time
    public static Semaphore safe = new Semaphore(2);     // max 2 tellers in safe
    public static Random rand = new Random();


    public static void main(String[] args) {
        System.out.println("Bank is open!");

        // create tellers
        Teller[] tellers = { new Teller(0), new Teller(1), new Teller(2) };

        // create customers
        Customer[] customers = new Customer[3]; //small for testing
        for (int i = 0; i < 3; i++) {
            customers[i] = new Customer(i, tellers);
        }

        // start customer threads
        for (Customer c : customers) {
            new Thread(c).start();
        }

        // waiting for all customers to fin
        try{
            Thread.sleep(5000); // need to adj as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Bank is closed!");
    }
}