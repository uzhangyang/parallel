package book.ch12.atomic;

import java.util.concurrent.Callable;

public class Selector implements Callable<Integer> {
    Counter counter;

    Selector(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        int value;
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            value = (int) (Math.random() * 100);
            if (value >= 50) {
                counter.add();
                sum++;
            }
        }
        return sum;
    }
}
