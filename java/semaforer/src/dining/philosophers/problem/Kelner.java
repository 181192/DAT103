package dining.philosophers.problem;

public class Kelner {
    private Spisepinne[][] spisepinner;
    private Filosof[] filosofer;

    private int antall;

    Kelner(int maks) {
        spisepinner = new Spisepinne[maks][2];
        filosofer = new Filosof[maks];
        antall = 0;
    }

    void dekkPaaSpisepinner() {
        int nummer = 1;
        int partall = 0;
        for (int r = 0; r < spisepinner.length; r++) {
            for (int k = 0; k < spisepinner[k].length; k++) {
                spisepinner[r][k] = new Spisepinne(nummer);
                if (partall % 2 == 0) {
                    nummer++;
                }
                if (nummer == spisepinner.length + 1) {
                    nummer = 1;
                }
                partall++;
            }
        }

        for (Spisepinne[] aSpisepinner : spisepinner) {
            for (Spisepinne anASpisepinner : aSpisepinner) {
                System.out.printf("%5d ", anASpisepinner.getNummer());
            }
            System.out.println();
        }

    }

    void tildelFilosofenePlasser() {
        for (int i = 0; i < filosofer.length; i++) {
            filosofer[i].setVenstrepinne(spisepinner[i][0]);
            filosofer[i].setHogrepinne(spisepinner[i][1]);
            System.out.println("Filosof " + filosofer[i].getNummer() + " har pinnene " + filosofer[i].getVenstrepinne().getNummer() + " og " + filosofer[i].getHogrepinne().getNummer());
        }
    }

    void laFilosofeneSpise() {
        for (Filosof aFilosofer : filosofer) {
            Thread filosofThread = new Thread(aFilosofer, "FilosofThread");
            filosofThread.start();
        }
    }

    void leggTilFilosof(Filosof filosof) {
        filosofer[antall] = filosof;
        antall++;
    }

    Spisepinne[][] getSpisepinner() {
        return spisepinner;
    }

    public void setSpisepinner(Spisepinne[][] spisepinner) {
        this.spisepinner = spisepinner;
    }

    public Filosof[] getFilosofer() {
        return filosofer;
    }

    public void setFilosofer(Filosof[] filosofer) {
        this.filosofer = filosofer;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }
}
