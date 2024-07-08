package book.ch12.customizedforkjointask;

import java.util.concurrent.ForkJoinPool;

public class Index {
    public static void main(String[] args) {
        int dataSize = 1000000;
        int[] array = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = 0;
        System.out.println("已经对数组初始化完毕");
        ForkJoinPool pool = new ForkJoinPool();
        IncreaseTask task = new IncreaseTask(array, 0, dataSize);
        pool.invoke(task);
        pool.shutdown();
    }
}
