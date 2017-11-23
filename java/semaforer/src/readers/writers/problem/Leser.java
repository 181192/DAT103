package readers.writers.problem;

import java.util.concurrent.Semaphore;

public class Leser implements Runnable {
    private Semaphore semLeser;
    private Semaphore semSkriver;
    private int lesere;

    Leser(Semaphore semLeser, Semaphore semSkriver, int lesere) {
        this.semLeser = semLeser;
        this.semSkriver = semSkriver;
        this.lesere = lesere;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        do {
            try {
                semLeser.acquire();
                lesere++;
                if (lesere == 1) {
                    semSkriver.acquire();
                }
                semLeser.release();
                System.out.println("\nTråden " + Thread.currentThread().getName() + " leser");
                Thread.sleep(100);
                semLeser.acquire();
                lesere--;
                if (lesere == 0) {
                    semSkriver.release();
                }
                semLeser.release();
                System.out.println("Tråden " + Thread.currentThread().getName() + " ferdig å lese");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
