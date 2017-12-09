package dining.philosophers.problem;

public class Main {
    private static int antall = 5;
    private static Filosof filosofer[] = new Filosof[antall];
    public static void main(String argv[]) {
        Kelner kelner = new Kelner(antall);
        for (int i = 0; i < antall; i++) {
            filosofer[i] = new Filosof(i);
            kelner.leggTilFilosof(filosofer[i]);
        }
        kelner.dekkPaaSpisepinner();
        kelner.tildelFilosofenePlasser();
        kelner.laFilosofeneSpise();

        while (true) {
            try {
                Thread.sleep(1000);
                boolean deadlock = true;
                for (int r = 0; r < kelner.getSpisepinner().length; r++) {
                    for (int k = 0; k < kelner.getSpisepinner()[r].length; k++) {
                        Spisepinne s = kelner.getSpisepinner()[r][k];
                        if (s.erLedig()) {
                            deadlock = false;
                            break;
                        }
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
        System.exit(0);
    }
}
