package book.ch4.lockfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Index {
    public static void main(String[] args) {
        final int N = 4;
        Lock locker = new ReentrantLock(false);
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Worker(locker);
            threads[i].start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
