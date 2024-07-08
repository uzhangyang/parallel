package book.ch10.fib;

import java.util.concurrent.RecursiveTask;

public class FibTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    Integer num;

    public FibTask(Integer num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        Integer result;
        if (num <= 10) {
            result = getValue(num);
        } else {
            FibTask fibTask1 = new FibTask(num - 1);
            FibTask fibTask2 = new FibTask(num - 2);
            fibTask1.fork();
            fibTask2.fork();
            result = fibTask1.join() + fibTask2.join();
        }
        return result;
    }

    private Integer getValue(Integer n) {
        Integer[] fib = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        return fib[n];
    }
}
