package book.ch4.lockfair;

import java.util.concurrent.locks.Lock;

public class Worker extends Thread {
    Lock locker;

    Worker(Lock locker) {
        this.locker = locker;
    }

    public void run() {
        locker.tryLock();
//		locker.lock();
        try {
            sleep(1000);
            System.out.println(this.getName()+"已经工作了1秒。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        locker.lock();
        try {
            sleep(1000);
            System.out.println(this.getName()+"已经休息了1秒。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
