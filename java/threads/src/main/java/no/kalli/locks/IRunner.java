package no.kalli.locks;

public interface IRunner {

    void firstThread() throws InterruptedException;

    void secondThread() throws InterruptedException;

    void finished();
}
