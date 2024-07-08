package book.ch12.mylock;

import java.util.concurrent.locks.Lock;

public class Increaser extends Thread {
    int[] array;
    Lock lock;

    Increaser(int[] array, Lock lock) {
        this.array = array;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(this.getName()+"开始对数组操作");
            for(int i=0; i<array.length; i++)
                array[i]++;
            System.out.println(this.getName()+"结束操作");

        } finally {
            lock.unlock();
        }
    }
}
