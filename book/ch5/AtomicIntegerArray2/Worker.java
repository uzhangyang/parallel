package book.ch5.AtomicIntegerArray2;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker extends Thread {
    AtomicInteger[] ai;

    public Worker(String name, AtomicInteger[] ai) {
        setName(name);
        this.ai = ai;
    }

    @Override
    public void run() {
        for (int i = 0; i < ai.length; i++) {
            ai[i].incrementAndGet();
        }
        System.out.println(getName() + "执行完毕");
    }
}
