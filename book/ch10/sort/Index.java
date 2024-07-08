package book.ch10.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Index {

    public static void main(String[] args) {
        int dataSize = 20000000;
        System.out.println("The number of threads is: " + Const.NTHREADS);
        Data data = new Data();
        data.generate(dataSize);
        System.out.println("Generating the data size is: " + dataSize);
        int[] bigData = data.getBigData();
        long start1 = System.nanoTime();
        Arrays.sort(bigData);
        long end1 = System.nanoTime();
        System.out.println("The time of sequence execution is: " + (end1 - start1));

        long start = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool();
        Worker worker = new Worker(bigData);
        pool.invoke(worker);
        long end = System.nanoTime();
        System.out.println("The time is: " + (end - start));
        do {
            System.out.printf("Main: Thread count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
        } while (!worker.isDone());
        if (data.check())
            System.out.println("The result is correct!");
        else
            System.out.println("The result is incorrect!");

        pool.shutdown();
    }

}
