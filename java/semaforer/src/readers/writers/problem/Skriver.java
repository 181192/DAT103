package readers.writers.problem;

import java.util.concurrent.Semaphore;

public class Skriver implements Runnable {
    private Semaphore s;

    Skriver(Semaphore semSkrive) {
        this.s = semSkrive;
    }


    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        do {
            try {
                s.acquire();
                //System.out.println("Tråden " + Thread.currentThread().getName() + " skriver");
                Thread.sleep(100);
                //System.out.println("Tråden " + Thread.currentThread().getName() + " er ferdig å skrive");
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(".");
        } while (true);
    }
}
