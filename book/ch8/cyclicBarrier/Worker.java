package book.ch8.cyclicBarrier;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker extends Thread {
    int[] arr;
    CyclicBarrier barrier;

    public Worker(int[] array, CyclicBarrier barrier) {
        this.arr = array;
        this.barrier = barrier;
    }

    public void run() {
        Arrays.sort(arr);
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
