package book.ch5.AtomicMarkableReference2;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class LockFreeNode<T> {

    public T data;
    public AtomicMarkableReference<LockFreeNode<T>> next;

    public LockFreeNode(T data) {
        this.data = data;
        this.next = new AtomicMarkableReference<LockFreeNode<T>>(null, false);
    }

    public LockFreeNode(T data, LockFreeNode<T> next) {
        this.data = data;
        this.next = new AtomicMarkableReference<LockFreeNode<T>>(next, false);
    }

    public boolean mark() {
        return next.attemptMark(next.getReference(), true);
    }

    public boolean isMarked() {
        return next.isMarked();
    }

}
