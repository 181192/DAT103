package no.kalli.volatiles;

import java.util.Scanner;

class Processor extends Thread {
    /*
    Bruker volatile for å forsikre at selv om vi kaller shutdown()
    i main tråden, vil fortsatt barne tråden stoppe.
    Vi forhindrer at variabelen running, blir buffret av systemet.
     */
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Trykk enter for å stoppe...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }
}
