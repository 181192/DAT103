package dining.philosophers.problem;

import java.util.concurrent.ThreadLocalRandom;

public class Filosof implements Runnable {
    private int nummer;
    private Spisepinne venstrepinne;
    private Spisepinne hogrepinne;

    Filosof(int nummer) {
        this.nummer = nummer;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement") // Intellij klager
    public void run() {
        System.out.println("Hei, jeg er filosof nummer " + nummer);
        do {
            venstrepinne.ta();
            System.out.println("Filosof nummer " + nummer + " tar venstre spisepinne");
            hogrepinne.ta();
            System.out.println("Filosof nummer " + nummer + " tar hogre spisepinne");
            spis();
            venstrepinne.slipp();
            System.out.println("Filosof nummer " + nummer + " slipper venstre spisepinne");
            hogrepinne.slipp();
            System.out.println("Filosof nummer " + nummer + " slipper hogre spisepinne");
            tenk();
        } while (true);
    }

    private void spis() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 500);
            System.out.println("Filosof nummer " + nummer + " spiser for " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void tenk() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("Filosof nummer " + nummer + " tenker for " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    Spisepinne getVenstrepinne() {
        return venstrepinne;
    }

    void setVenstrepinne(Spisepinne venstrepinne) {
        this.venstrepinne = venstrepinne;
    }

    Spisepinne getHogrepinne() {
        return hogrepinne;
    }

    void setHogrepinne(Spisepinne hogrepinne) {
        this.hogrepinne = hogrepinne;
    }

    int getNummer() {
        return nummer;
    }
}
