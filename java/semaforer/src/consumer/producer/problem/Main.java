package consumer.producer.problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int ANTALL = 10;
    static final int K_RUNDER = 10;
    static final int P_RUNDER = K_RUNDER * ANTALL;

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        List<Thread> threads = new ArrayList<>();

        Thread p = new Thread(new Produsent(buffer), "ProdusentThread  ");
        p.start();
        threads.add(p);

        int n = 0;
        while (n < ANTALL) {
            Thread k = new Thread(new Konsument(buffer), "KonsumentThread " + n++);
            threads.add(k);
            k.start();
        }

        n = 0;
        while (n < ANTALL) {
            try {
                threads.get(n++).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Antallet i bufferen er: " + buffer.antall() + " og bufferen er tom? " + buffer.erTom());
    }
}

