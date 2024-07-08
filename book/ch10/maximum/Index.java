package book.ch10.maximum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Index {
    public static void main(String[] args) {
        int threshold;
        threshold = 10000000;
        int nthreads = 2;
        int size = threshold * nthreads;
        BigData bd = new BigData(size);
        System.out.printf("类Index:%d个元素的数组被创建 \n", size);
        Integer[] bigData = bd.getBigData();
        ForkJoinPool pool = new ForkJoinPool();
        MaxTask task = new MaxTask(bigData, 0, bigData.length, nthreads, threshold);
        pool.invoke(task);
        try {
            System.out.println("类Index:最大值为"+ task.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

}
