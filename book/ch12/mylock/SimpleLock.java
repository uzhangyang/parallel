package book.ch12.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SimpleLock implements Lock {

    private final CustomizedSynchronizer synchronizer = new CustomizedSynchronizer();

    @Override
    public void lock() {
        synchronizer.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        synchronizer.acquireInterruptibly(1);
    }

    @Override
    public Condition newCondition() {
        return synchronizer.new ConditionObject();
    }

    @Override
    public boolean tryLock() {
        return synchronizer.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long arg0, TimeUnit arg1)
            throws InterruptedException {
        return synchronizer.tryAcquireNanos(1, arg1.toNanos(arg0));
    }

    @Override
    public void unlock() {
        synchronizer.release(1);
    }

}
