package book.ch6.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Index {

    public static final int N = 10000000;
    public static final int THREADS = 4;

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * N);
        }
        int[] dataRange = new int[THREADS + 1];
        for (int i = 0; i <= THREADS; i++) {
            dataRange[i] = i * N / THREADS;
            if (dataRange[i] > N)
                dataRange[i] = N;
        }
        Worker[] workers = new Worker[THREADS];
        System.out.println("生成"+THREADS + "个线程");
        List<FutureTask<Integer>> taskLists =
                new ArrayList<FutureTask<Integer>>();
        for (int i = 0; i < THREADS; i++) {
            workers[i] = new Worker(array, dataRange[i], dataRange[i + 1]);
            System.out.println("第" + i + "个线程将处理数据范围("
                    +dataRange[i]+","+dataRange[i + 1]+")");
            FutureTask<Integer> task = new FutureTask<Integer>(workers[i]);
            taskLists.add(task);
            Thread t = new Thread(task);
            t.start();
        }
        Integer max = -1;
        for (FutureTask<Integer> task : taskLists) {
            Integer temp = null;
            try {
                temp = task.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            if (max < temp)
                max = temp;
        }
        System.out.println("最大值是" + max);
        long end = System.currentTimeMillis();
        System.out.println("共计花费时间为："+ (end-begin)+"毫秒");
    }
}
