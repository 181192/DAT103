package no.kalli.part1.thread1;

class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();

        runner1.start();
        runner2.start();
    }
}
