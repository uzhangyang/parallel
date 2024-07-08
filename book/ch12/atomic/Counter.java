package book.ch12.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends AtomicInteger {
    private static final long serialVersionUID = 1L;
    private int number;

    Counter() {
        super.set(0);
        number = 0;
    }

    public boolean add() {
        while (true) {
            number = super.get();
            boolean hasAdd = super.compareAndSet(number, number + 1);
            if (hasAdd) {
                return true;
            }
        }
    }


}
