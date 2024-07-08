package book.ch5.AtomicIntegerArray;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Worker extends Thread {
    AtomicIntegerArray aia;

    public Worker(String name, AtomicIntegerArray aia) {
        setName(name);
        this.aia = aia;
    }

    @Override
    public void run() {
        for (int i = 0; i < aia.length(); i++) {
            aia.incrementAndGet(i);
        }
        System.out.println(getName() + "执行完毕");
    }
}
