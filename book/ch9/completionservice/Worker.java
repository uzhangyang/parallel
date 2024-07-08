package book.ch9.completionservice;

import java.util.concurrent.Callable;

public class Worker implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        long start = System.currentTimeMillis();
        int rand = (int) (Math.random() * Integer.MAX_VALUE);
        for (int i = 0, sum = 0; i < rand; i++)
            sum += 1;
        long end = System.currentTimeMillis();
        return (end - start);
    }

}
