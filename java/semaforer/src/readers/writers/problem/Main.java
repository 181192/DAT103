package readers.writers.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Main {
    private static final int ANTALL = 10;
    public static void main(String[] args) throws Exception {
        int readCount = 0;
        Semaphore semLeser = new Semaphore(ANTALL);
        Semaphore semSkriver = new Semaphore(1);
        List<Thread> threads = new ArrayList<>();
        int n = 0;
        while (n < ANTALL) {
            Thread leser = new Thread(new Leser(semLeser,semSkriver, readCount), "Leser-tråd " + n);
            Thread skriver = new Thread(new Skriver(semSkriver), "Skriver-tråd " + n);
            threads.add(skriver);
            threads.add(leser);
            n++;
        }
        n = 0;
        while(n < threads.size()) {
           threads.get(n++).start();
        }
    }
}