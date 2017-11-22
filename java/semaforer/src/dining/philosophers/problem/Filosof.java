package dining.philosophers.problem;

import java.util.concurrent.ThreadLocalRandom;

public class Filosof implements Runnable {
    private int nummer;
    private Spisepinne venstrepinne;
    private Spisepinne hogrepinne;

    Filosof(int nummer, Spisepinne venstrepinne, Spisepinne hogrepinne) {
        this.nummer = nummer;
        this.venstrepinne = venstrepinne;
        this.hogrepinne = hogrepinne;
    }

    public void run(){
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
        } while (true);
    }

    private void spis() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("Filosof nummer " + nummer + " spiser for " + sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
