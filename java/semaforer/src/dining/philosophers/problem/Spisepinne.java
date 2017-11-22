package dining.philosophers.problem;

import java.util.concurrent.Semaphore;

class Spisepinne {
    private Semaphore semafor = new Semaphore(1);
    private int nummer;

    Spisepinne(int nummer) {
        this.nummer = nummer;
    }

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

    boolean erLedig() {
        return semafor.availablePermits() > 0;
    }

    int getNummer() {
        return nummer;
    }
}
