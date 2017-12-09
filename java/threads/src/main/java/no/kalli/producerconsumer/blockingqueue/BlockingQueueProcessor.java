package no.kalli.producerconsumer.blockingqueue;

import no.kalli.producerconsumer.IProcessor;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProcessor implements IProcessor {

    private BlockingQueue<Integer> queue;

    BlockingQueueProcessor(int maxantall) {
        this.queue = new ArrayBlockingQueue<Integer>(maxantall);
    }

    public void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(100);

            if (random.nextInt(10) == 0) {
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}
