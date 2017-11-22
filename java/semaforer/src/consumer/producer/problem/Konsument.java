package consumer.producer.problem;

import static consumer.producer.problem.Main.K_RUNDER;

public class Konsument implements Runnable {
    private Buffer buffer;

    Konsument(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < K_RUNDER; i++) {
            buffer.konsumer();
        }
    }
}
