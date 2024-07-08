package book.ch3.bucketsort;

import java.util.ArrayList;
import java.util.Collections;

public class SortAsUsual {

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
        System.out.println("开始排序...");
        long s_start = System.currentTimeMillis();
        Collections.sort(data);
        long s_end = System.currentTimeMillis();
        System.out.println("排序完成...");
        System.out.println("排序算法串行执行的时间为"+(s_end-s_start)+"毫秒");
    }
}
