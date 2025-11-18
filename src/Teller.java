import java.util.concurrent.Semaphore;

public class Teller {
    int id;
    //Semaphore semaphore;

    public Teller(int id) {
        this.id = id;
    }

    public void serveCustomer(Customer c) {
        System.out.println("Teller " + id + "[" + c.id + "]: asks for transaction");

        // if withdraw,then interact w manager
        if (c.transactionType.equals("Withdraw")) {
            try {
                System.out.println("Teller " + id + "[" + c.id + "]: going to manager");

                BankSimulation.manager.acquire();

                System.out.println("Teller " + id + "[" + c.id + "]: interacting with manager");
                Thread.sleep(BankSimulation.rand.nextInt(26) + 5); // 5 to30 ms
                System.out.println("Teller " + id + "[" + c.id + "]: done with manager");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                BankSimulation.manager.release();
            }
        }

        // go to safe, MAX 2 tellers
        try {
            System.out.println("Teller " + id + "[" + c.id + "]: waiting for safe");
            BankSimulation.safe.acquire();
            System.out.println("Teller " + id + "[" + c.id + "]: using safe");
            Thread.sleep(BankSimulation.rand.nextInt(41) + 10); // 10 to 50 ms
            System.out.println("Teller " + id + "[" + c.id + "]: done with safe");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            BankSimulation.safe.release();
        }

        System.out.println("Customer " + c.id + " leaves bank");

    }
}

