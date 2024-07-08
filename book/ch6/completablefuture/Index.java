package book.ch6.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import java.util.function.Supplier;

public class Index {
    //定义常量N，代表数据大小
    public static final int N = 10000000;
    //定义常量TASKS，代表线程个数
    public static final int TASKS = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //定义一个数组，用于存放数据
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * N);
        }
        //对数据进行划分，让每个异步任务处理一段数据
        int[] dataRange = new int[TASKS + 1];
        for (int i = 0; i <= TASKS; i++) {
            dataRange[i] = i * N / TASKS;
            if (dataRange[i] > N)
                dataRange[i] = N;
        }
        //生成异步任务数组
        CompletableFuture<Integer>[] workers = new CompletableFuture[TASKS];
        System.out.println("生成"+ TASKS + "个异步任务");
        for (int i = 0; i < TASKS; i++) {
            int  temp = i;
            //生成每一个异步任务
            workers[i] = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int begin = dataRange[temp];
                    int end = dataRange[temp+1];
                    System.out.println("第" + temp + "个异步任务将处理数据范围("
                            +dataRange[temp]+","+dataRange[temp + 1]+")");
                    Integer max = array[begin];
                    for (int j = begin + 1; j < end; j++)
                        if (max < array[j])
                            max = array[j];
                    return max;
                }
            });
        }
        //所有的异步任务都已经计算得到结果
        CompletableFuture.allOf(workers).join();
        //获取异步任务的最大值
        Integer max = -1;
        for (CompletableFuture<Integer> task : workers) {
            Integer temp = temp = task.get();
            if (max < temp)
                max = temp;
        }
        System.out.println("最大值是" + max);
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("共计花费时间为："+ (end-begin)+"毫秒");
    }

}
