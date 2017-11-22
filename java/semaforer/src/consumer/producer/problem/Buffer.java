package consumer.producer.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Buffer {
    private Semaphore semKonsument = new Semaphore(0);
    private Semaphore semProdusent = new Semaphore(1);
    private List<Integer> buffer;
    private int antall;

    Buffer() {
        this.buffer = new ArrayList<>();
        antall = 0;
    }

    void produser(int i) {
        try {
            semProdusent.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer.add(i);
        antall++;
        System.out.println(Thread.currentThread().getName() + " produserer");
        semKonsument.release();
    }

    void konsumer() {
        try {
            semKonsument.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer.remove(antall - 1);
        antall--;
        System.out.println(Thread.currentThread().getName() + " konsumerer");
        semProdusent.release();
    }

    boolean erTom() {
        return antall == 0 && buffer.size() == 0;
    }

    int antall() {
        return antall;
    }
}
