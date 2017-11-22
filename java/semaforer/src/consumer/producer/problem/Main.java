package consumer.producer.problem;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semProdusent = new Semaphore(1);
        Semaphore semKonsument = new Semaphore(0);

        Produsent produsent = new Produsent(semProdusent, semKonsument);
        Konsument konsument = new Konsument(semProdusent, semKonsument);

        Thread produsentThread = new Thread(produsent, "ProdusentThread");
        Thread konsumentThread = new Thread(konsument, "KonsumentThread");

        produsentThread.start();
        konsumentThread.start();
    }
}

