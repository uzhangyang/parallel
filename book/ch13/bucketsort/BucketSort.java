package book.ch3.bucketsort;

import java.util.ArrayList;

public class BucketSort {

    public static final int N = 10000000;
    public static final int BUCKET = 10;

    public static ArrayList<Integer> generate_data() {
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            data.add((int) (Math.random() * N));
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println("生成" + N + "个数据中...");
        ArrayList<Integer> data = generate_data();

        long b_start = System.currentTimeMillis();
        System.out.println("生成" + BUCKET + "个桶...");
        //定义桶
        ArrayList[] buckets = new ArrayList[BUCKET];
        //对每一个桶进行初始化
        for (int i = 0; i < BUCKET; i++)
            buckets[i] = new ArrayList<Integer>();
        //为了方便定义每个数据属于哪个桶，构建每个桶的范围range
        int range = N / BUCKET;
        System.out.println("正在将数据放入每个桶中..");
        for (int i = 0; i < N; i++) {
            int temp = data.get(i);
            int index = temp / range;
            buckets[index].add(temp);
        }
        System.out.println("正在将每个桶中的数据进行排序..");
        Thread[] workers = new Thread[BUCKET];
        for (int t = 0; t < BUCKET; t++) {
            workers[t] = new Thread(new Worker(buckets[t]));
            workers[t].start();
        }
        // 等待线程执行结束
        for (int t = 0; t < BUCKET; t++) {
            try {
                workers[t].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在将所有数据汇总..");
        ArrayList<Integer> sortedData = new ArrayList<Integer>();
        for (int t = 0; t < BUCKET; t++) {
            sortedData.addAll(buckets[t]);
        }
        System.out.println("桶排序并行处理完毕！");
        long b_end = System.currentTimeMillis();
        System.out.println("排序算法并行执行的时间为" + (b_end - b_start) + "毫秒");

        for (int i = 0; i < N - 1; i++)
            if ((Integer) sortedData.get(i) > (Integer) sortedData.get(i + 1))
                System.out.println("验证失败");
    }
}
