import java.util.concurrent.Semaphore;

public class Konsument implements Runnable {
    private Semaphore semProdusent;
    private Semaphore semKonsument;

    Konsument(Semaphore semProdusent, Semaphore semKonsument) {
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
                semKonsument.acquire();
                System.out.println("Konsument: " + i);
                semProdusent.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
