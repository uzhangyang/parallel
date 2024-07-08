package book.ch13.oddevensort;

import java.util.Arrays;

public class Parallel {
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
    //实现两个数组的数据交换，两个数组中小的数据存放到data1中，大的数据存放到data2中
    public static void exchanger(int[] data1, int[] data2) {
        // 定义data3，用于存放两个数组的合并
        int[] data3 = Arrays.copyOf(data1, WIDTH * 2);
        //将数组data2中的数据拷贝到data3中
        System.arraycopy(data2, 0, data3, WIDTH, WIDTH);
        // 排序
        Arrays.sort(data3);
        // 数据分发
        for (int i = 0; i < WIDTH; i++) {
            data1[i] = data3[i];
            data2[i] = data3[i + WIDTH];
        }
    }

    public static void main(String[] args) {
        System.out.println("生成" + N + "个数据中...");
        int[] data = generate_data();
        //开始时间
        long start = System.currentTimeMillis();
        // 将data数组中的元素分别放入不同数组中，方便线程处理
        int[][] subdata = new int[THREADS][WIDTH];
        for (int i = 0; i < THREADS; i++) {
            subdata[i] = Arrays.copyOfRange(data, i*WIDTH, (i+1)*WIDTH);
        }
        //定义线程数组
        Thread[] threads = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            //线程初始化
            threads[i] = new Worker(subdata[i]);
            //启动线程
            threads[i].start();
            //等待线程执行结束
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 并行奇偶排序算法
        for (int phase = 0; phase < THREADS; phase++) {
            if (phase % 2 == 0) {
                for (int j = 0; j < THREADS - 1; j += 2) {
                    exchanger(subdata[j], subdata[j + 1]);
                }
            } else {
                for (int k = 1; k < THREADS - 1; k += 2) {
                    exchanger(subdata[k], subdata[k + 1]);
                }
            }
        }
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println(N + "个数据并行排序需要" +  + (end - start) + "毫秒");
        //对排序后的结果进行验证，验证subdata中的数据是否有序
        for (int i = 0; i < THREADS; i++)
            for (int j = 0; j < WIDTH - 1; j++)
                if (subdata[i][j] > subdata[i][j + 1])
                    System.out.println("验证失败");
        // 验证相邻两个数组的相邻元素是否有序
        for (int i = 0; i < THREADS - 1; i++)
            if (subdata[i][WIDTH - 1] > subdata[i + 1][0]) {
                System.out.println("验证失败" + subdata[i][WIDTH - 1] + " " + subdata[i + 1][0]);
            }
    }
}
