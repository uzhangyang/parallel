package book.ch8.semaphore;

import java.util.concurrent.Semaphore;

public class Index {

    public static void main(String[] args) {
        Semaphore counter = new Semaphore(4);
        Thread[] th = new Thread[20];
        for (int i = 0; i < 20; i++) {
            th[i] = new Customer(counter, i + 1);
            th[i].start();
        }
    }

}
