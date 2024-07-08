package book.ch3.max;

import java.util.concurrent.Callable;

public class FindTask implements Callable<Integer> {
    Integer a[];

    public FindTask(Integer a[]) {
        this.a = a;
    }

    @Override
    public Integer call() throws Exception {
        Integer max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }
}
