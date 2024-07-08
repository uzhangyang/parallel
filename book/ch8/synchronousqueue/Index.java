package book.ch8.synchronousqueue;

import java.util.concurrent.SynchronousQueue;

public class Index {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}
