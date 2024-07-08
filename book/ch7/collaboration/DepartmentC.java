package book.ch7.collaboration;

import java.util.concurrent.locks.ReadWriteLock;

public class DepartmentC implements Runnable {

    ReadWriteLock lock;

    DepartmentC(ReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.writeLock().lock();
//            if (Index.a == 2) {
//                System.out.println("丙部门开始运输");
//                Index.a = 0;
//            }
//            lock.writeLock().unlock();
//        }


        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().lock();
        if (Index.a == 2) {
            System.out.println("丙部门开始运输");
            lock.readLock().unlock();
            lock.writeLock().lock();
            Index.a = 0;
            lock.writeLock().unlock();
        } else {
            lock.readLock().unlock();
        }


    }
}
