package book.ch12.mylock;

import java.util.concurrent.locks.Lock;

public class Index {

    public static void main(String[] args) {
        Lock lock = new SimpleLock();
        int arrayNum = 1000000;
        int[] array = new int[arrayNum];
        for (int i = 0; i < arrayNum; i++) {
            array[i] = 0;
        }
        Thread t1 = new Increaser(array, lock);
        Thread t2 = new Increaser(array, lock);
        t1.start();
        t2.start();
    }

}
