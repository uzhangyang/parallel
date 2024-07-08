package book.ch4.trylock;

import java.util.concurrent.locks.Lock;

public class Worker extends Thread {

    Lock locker;

    Worker(Lock locker) {
        this.locker = locker;
    }

    public void run() {
        if (locker.tryLock()) {
            try {
                sleep(1000);
                System.out.println(this.getName() + "�Ѿ�������1��.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.unlock();
            }
        }


        if (locker.tryLock()) {
            try {
                sleep(1000);
                System.out.println(this.getName() + "�Ѿ���Ϣ��1��.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.unlock();
            }
        }
    }
}
