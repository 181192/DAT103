package readers.writers.problem;

import java.util.concurrent.Semaphore;

public class Leser implements Runnable {
    private Semaphore readLock;
    private Semaphore writeLock;
    private int readCount;

    Leser(Semaphore readLock, Semaphore writeLock, int readCount) {
        this.readLock = readLock;
        this.writeLock = writeLock;
        this.readCount = readCount;
    }

    @Override
    public void run() {
        try {
            //Acquire Section
            readLock.acquire();
            readCount++;
            if (readCount == 1) {
                writeLock.acquire();
            }
            readLock.release();

            //Reading section
            System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
            Thread.sleep(1500);
            System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");

            //Releasing section
            readLock.acquire();
            readCount--;
            if (readCount == 0) {
                writeLock.release();
            }
            readLock.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
