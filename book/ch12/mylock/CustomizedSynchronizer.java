package book.ch12.mylock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CustomizedSynchronizer extends AbstractQueuedSynchronizer {
    private AtomicInteger state;

    public CustomizedSynchronizer() {
        state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int val) {
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int val) {
        return state.compareAndSet(1, 0);
    }
}
