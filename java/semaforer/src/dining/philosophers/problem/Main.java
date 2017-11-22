package dining.philosophers.problem;

public class Main {
    static int antall = 5;
    static Filosof filosofer[] = new Filosof[antall];
    static Spisepinne[] spisepinner = new Spisepinne[antall];

    public static void main(String argv[]) {
        System.out.println("Dining philosophers problem.");

        for (int i = 0; i < antall; i++) {
            spisepinner[i] = new Spisepinne();
        }

        for (int i = 0; i < antall; i++) {
            filosofer[i] = new Filosof(i, spisepinner[i], spisepinner[(i + 1) % antall]);
            Thread filosofThread = new Thread(filosofer[i], "FilosofThread");
            filosofThread.start();
        }

        while (true) {
            try {
                // sleep 1 sec
                Thread.sleep(1000);

                // check for deadlock
                boolean deadlock = true;
                for (Spisepinne f : spisepinner) {
                    if (f.erLedig()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(1000);
                    System.out.println("Hurray! There is a deadlock!");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        System.out.println("Bye!");
        System.exit(0);
    }
}
