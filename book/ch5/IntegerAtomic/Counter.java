package book.ch5.IntegerAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger ia = new AtomicInteger();

    public void increase() {
        ia.getAndIncrement();
    }

    public int get() {
        return ia.get();
    }
}
