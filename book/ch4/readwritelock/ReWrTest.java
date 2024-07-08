package book.ch4.readwritelock;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReWrTest {

    private List<Integer> myList;

    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private Lock readLock = rwlock.readLock();
    private Lock writeLock = rwlock.writeLock();


    public ReWrTest(List<Integer> myList) {
        this.myList = myList;
    }

    public Object get(int index) {
        readLock.lock();
        try {
            return myList.get(index);
        } finally {
            readLock.unlock();
        }
    }

    public boolean insert(int newValue) {
        writeLock.lock();
        try {
            return myList.add((Integer) newValue);
        } finally {
            writeLock.unlock();
        }

    }

}
