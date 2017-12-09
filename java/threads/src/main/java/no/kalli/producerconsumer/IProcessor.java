package no.kalli.producerconsumer;

public interface IProcessor {
    /**
     * Produserer
     *
     * @throws InterruptedException Interupt exception
     */
    void produce() throws InterruptedException;

    /**
     * Konsumere
     *
     * @throws InterruptedException Interupt exception
     */
    void consume() throws InterruptedException;
}
