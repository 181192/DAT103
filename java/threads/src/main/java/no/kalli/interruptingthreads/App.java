package no.kalli.interruptingthreads;

import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting...");

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> fu = executorService.submit(new Callable<Void>() {
            public Void call() {
                Random random = new Random();
                for (int i = 0; i < 1E8; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });

        executorService.shutdown();
        Thread.sleep(500);

        executorService.shutdownNow();
        //fu.cancel(true);

        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("Finished!");
    }
}
