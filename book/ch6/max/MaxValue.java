package book.ch6.max;

public class MaxValue {

    public static final int N = 10000000;

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * N);
        }
        Integer max = array[0];
        for (int i = 1; i < N; i++) {
            if (max < array[i])
                max = array[i];
        }
        System.out.println("最大值为："+max);
        long end = System.currentTimeMillis();
        System.out.print("花费时间：" + (end - begin)+"毫秒");
    }
}

