import java.util.concurrent.Semaphore;

public class Produsent implements Runnable {
    private Semaphore semProdusent;
    private Semaphore semKonsument;

    Produsent(Semaphore semProdusent, Semaphore semKonsument) {
        this.semProdusent = semProdusent;
        this.semKonsument = semKonsument;
    }

    @Override
    public void run() {
//        do {
//
//            /* produce an item in next_produced */
//            // wait(empty);
//            // wait(mutex);
//
//            /* add next produced to the buffer */
//            // signal(mutex);
//            // signal(full);
//
//        } while (true);
        for (int i = 0; i < 5; i++) {
            try {
                semProdusent.acquire();
                System.out.println("Produsent: " + i);
                semKonsument.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
