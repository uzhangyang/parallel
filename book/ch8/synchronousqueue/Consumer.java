package book.ch8.synchronousqueue;

import java.util.concurrent.SynchronousQueue;

public class Consumer extends Thread {
    SynchronousQueue<Integer> queue;

    Consumer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }


    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("消费者消费了一个数据：" +queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
