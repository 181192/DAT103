package readers.writers.problem;

import java.util.concurrent.Semaphore;

class Main {
    public static int readCount = 0;
    public static void main(String[] args) throws Exception {
        Semaphore readLock = new Semaphore(1);
        Semaphore writeLock = new Semaphore(1);

        Skriver skriver = new Skriver(readLock, writeLock);
        Leser leser = new Leser(readLock, writeLock, 0);
        Thread t1 = new Thread(leser, "thread1");
        Thread t2 = new Thread(leser, "thread2");
        Thread t3 = new Thread(skriver, "thread3");
        Thread t4 = new Thread(skriver, "thread4");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
}