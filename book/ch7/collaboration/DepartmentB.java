package book.ch7.collaboration;

import java.util.concurrent.locks.ReadWriteLock;

public class DepartmentB implements Runnable {

    ReadWriteLock lock;

    DepartmentB(ReadWriteLock lock) {
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
//            if (Index.a == 1) {
//                System.out.println("乙部门开始生产");
//                Index.a = 2;
//            }
//            lock.writeLock().unlock();
//        }


        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().lock();
        if (Index.a == 1) {
            System.out.println("乙部门开始生产");
            lock.readLock().unlock();
            lock.writeLock().lock();
            Index.a = 2;
            lock.writeLock().unlock();
        } else {
            lock.readLock().unlock();
        }


    }
}
