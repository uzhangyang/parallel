package book.ch12.workthreadinforkjoinpool;

import java.util.concurrent.RecursiveTask;

public class WorkerTask extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1L;
    private int num;

    WorkerTask(int num) {
        this.num = num;
    }

    @Override
    protected Long compute() {
        Long result;
        if (num <= 10) {
            result = getValue(num);
        } else {
            WorkerTask fibTask1 = new WorkerTask(num - 1);
            WorkerTask fibTask2 = new WorkerTask(num - 2);
            fibTask1.fork();
            fibTask2.fork();
            result = fibTask1.join() + fibTask2.join();
        }
        return result;
    }

    private Long getValue(Integer n) {
        Long[] fib = {1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L};
        return fib[n];
    }

}
