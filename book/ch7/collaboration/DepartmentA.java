package book.ch7.collaboration;

import java.util.concurrent.locks.ReadWriteLock;

public class DepartmentA implements Runnable {

    ReadWriteLock lock;

    DepartmentA(ReadWriteLock lock) {
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
//            if(Index.a ==0){
//                System.out.println("甲部门开始运送原材料");
//                Index.a = 1;
//
//            }
//            lock.writeLock().unlock();
//
//        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().lock();
        if (Index.a == 0) {
            System.out.println("甲部门开始运送原材料");
            lock.readLock().unlock();
            lock.writeLock().lock();
            Index.a = 1;
            lock.writeLock().unlock();
        } else {
            lock.readLock().unlock();
        }


    }
}
