package consumer.producer.problem;

import static consumer.producer.problem.Main.P_RUNDER;

public class Produsent implements Runnable {
    private Buffer buffer;

    Produsent(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < P_RUNDER; i++) {
            buffer.produser(i);
        }
    }
}
