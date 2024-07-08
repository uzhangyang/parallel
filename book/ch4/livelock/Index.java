package book.ch4.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Index {
    public static void main(String[] args) {

        Lock locker = new ReentrantLock();
        String name = "NormalThread";
        Thread thread1 = new Worker(locker, name);
        String name2 = "ErgentThread";
        Thread thread2 = new Worker(locker, name2);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }

}
