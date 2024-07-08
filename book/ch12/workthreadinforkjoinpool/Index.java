package book.ch12.workthreadinforkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Index {
    public static void main(String[] args) {
        PrintInfoThreadFactory factory = new PrintInfoThreadFactory();
        ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);
        WorkerTask worker = new WorkerTask(20);
        pool.execute(worker);
        worker.join();
        try {
            System.out.println("结果为:" + worker.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
