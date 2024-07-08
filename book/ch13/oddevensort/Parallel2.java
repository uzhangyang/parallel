package book.ch13.oddevensort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parallel2 {
    //数据量大小
    public static final int N = 100000;
    // 线程数
    public static final int THREADS = 4;
    // 分段大小，根据线程数对数据进行分段
    public static final int WIDTH = N / THREADS;
    // 生成N个随机数据
    public static int[] generate_data() {
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = (int) (Math.random() * N);
        }
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("生成" + N + "个数据中...");
        int[] data = generate_data();
        //开始时间
        long start = System.currentTimeMillis();
        // 表明奇数阶段或偶数阶段
        int start_index;
        // 现成列表
        List<Thread> threads = new ArrayList<>();
        //并行奇偶排序
        for (int phrase = 0; phrase < THREADS; phrase++) {
            // 表明当前是哪个阶段
            start_index = phrase % 2 == 0 ? 0 : 1;
            for (int j = start_index; j < THREADS - 1; j += 2) {
                //生成线程，共享内存模式排序
                int finalJ = j;
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Arrays.sort(data, finalJ * WIDTH, (finalJ + 2) * WIDTH);
                    }
                });
                //放入线程列表
                threads.add(t);
                //线程开始执行
                t.start();
            }
            // 等待所有线程结束
            for (Thread t: threads)
                t.join();
            //当前阶段完成后，线程列表清空，为下一个阶段做准备
            threads.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println(N + "个数据并行排序需要" + +(end - start) + "毫秒");
        // 验证排序结果
        for (int i = 0; i < N - 1; i++)
            if (data[i] > data[i + 1])
                System.out.println("验证失败");
    }
}
