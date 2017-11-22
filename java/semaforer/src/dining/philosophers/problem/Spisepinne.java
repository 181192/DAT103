package dining.philosophers.problem;

import java.util.concurrent.Semaphore;

public class Spisepinne {
    private Semaphore semafor = new Semaphore(1);

    void ta() {
        try {
            semafor.acquire();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    void slipp() {
        semafor.release();
    }

    public boolean erLedig() {
        return semafor.availablePermits() > 0;
    }
}
