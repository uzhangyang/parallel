package book.ch3.join;

public class Worker implements Runnable {
    int[] arr;
    Thread thread;

    public Worker(int[] arr, Thread thread) {
        this.arr = arr;
        this.thread = thread;
    }

    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        Index.sum = sum;
    }
}
