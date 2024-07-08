package book.ch8.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Index {

    public static void main(String[] args) {
        int N = 1000000;
        int[] datum = new int[N];
        int[] copy = new int[N];
        for (int i = 0; i < N; i++) {
            datum[i] = (int) (Math.random() * 10);
            copy[i] = datum[i];
        }

        int nthread = 2;
        int segment = N / nthread;
        int[] range = new int[nthread + 1];
        for (int i = 0; i <= nthread; i++) {
            range[i] = segment * i;
            if (range[i] > N)
                range[i] = N;
        }
        System.out.println("将数据划分为:");
        for(int i=0; i<nthread; i++){
            System.out.println("开始下标：" +range[i] + "结束下标"+range[i+1]);
        }

        CountDownLatch cdl = new CountDownLatch(nthread);
        Thread[] threads = new Thread[nthread];
        for (int i = 0; i < nthread; i++) {
            threads[i] = new Worker(datum, range[i], range[i + 1], cdl);
            threads[i].start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean pass = true;
        for (int i = 0; i < N; i++) {
            if (datum[i] != copy[i] + 1) {
                pass = false;
                break;
            }
        }
        if(pass){
            System.out.println("结果正确");
        }else{
            System.out.println("结果错误");
        }

    }

}
