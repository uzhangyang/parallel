package book.ch5.AtomicIntegerArray;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Index {
    public static void main(String[] args) {
        AtomicIntegerArray aia = new AtomicIntegerArray(10000);
        for (int i = 0; i < 10000; i++) {
            aia.set(i, 0);
        }
        System.out.println("初始化完毕。");
        Thread w1 = new Worker("工人1", aia);
        Thread w2 = new Worker("工人2", aia);
        Thread w3 = new Worker("工人3", aia);
        Thread w4 = new Worker("工人4", aia);

        w1.start();
        w2.start();
        w3.start();
        w4.start();
        try {
            w1.join();
            w2.join();
            w3.join();
            w4.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        for (int i = 0; i < 10000; i++) {
            if (aia.get(i) != 4) {
                System.out.println("验证失败！");
                break;
            }
        }
    }
}
