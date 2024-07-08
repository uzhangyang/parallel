package book.ch8.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {

    int[] array;
    int from;
    int to;
    CountDownLatch cdl;

    Worker(int[] array, int from, int to, CountDownLatch cdl) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.cdl = cdl;
    }

    public void run() {
        for (int i = from; i < to; i++) {
            array[i]++;
        }
        cdl.countDown();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
