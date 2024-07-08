package book.ch7.collaboration;


import java.util.concurrent.locks.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Index {

    public volatile static int a = 0;

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLock lock = new ReentrantReadWriteLock();

        DepartmentA da = new DepartmentA(lock);
        Thread tda = new Thread(da);
        tda.start();

        DepartmentB db = new DepartmentB(lock);
        Thread tdb = new Thread(db);
        tdb.start();

        DepartmentC dc = new DepartmentC(lock);
        Thread tdc = new Thread(dc);
        tdc.start();

        tda.join();
        tdb.join();
        tdc.join();
    }

}
