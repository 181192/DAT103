package no.kalli.syncmethods;

public class App {

    private int count = 0;

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                loop();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                loop();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }

    private void loop() {
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }

    /**
     * Synkroniserer inkrementasjonen av variabelen count
     */
    private synchronized void increment() {
        count++;
    }
}
