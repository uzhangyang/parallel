package book.ch10.fib;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Index {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(2);
        ForkJoinTask<Integer> fjtask = new FibTask(38);
        pool.execute(fjtask);
        do {
            System.out.println("***************************************");
            System.out.printf("类Index: 并行度: %d\n", 2);
            System.out.printf("类Index: 活动线程数: %d\n", pool.getActiveThreadCount());
            System.out.printf("类Index: 任务数: %d\n", pool.getQueuedTaskCount());
            System.out.printf("类Index: 窃取任务数: %d\n", pool.getStealCount());
//            System.out.println("***************************************");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!fjtask.isDone());
        System.out.println(fjtask.join());
        pool.shutdown();
    }
}
