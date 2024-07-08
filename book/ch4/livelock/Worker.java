package book.ch4.livelock;

import java.util.concurrent.locks.Lock;

public class Worker extends Thread {

    Lock locker;
    String name;
    static Integer id = 1;

    Worker(Lock locker, String name) {
        this.locker = locker;
        this.name = name;
    }

    public void run() {
        locker.lock();
        try {
            System.out.println(name + " 开始运行...");
            if (id < 20) {
                Thread newThread = new Worker(locker, "Thread-" + id.toString());
                newThread.setPriority(MAX_PRIORITY);
                newThread.start();
            }
            id++;
        } finally {
            locker.unlock();
        }

    }
}
