package book.ch5.AtomicMarkableReference2;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeLinkedlist<T> {
    AtomicReference<LockFreeNode<T>> head;

    public LockFreeLinkedlist() {
        head = new AtomicReference<LockFreeNode<T>>(null);
    }

    public boolean insert(T data) {
        System.out.println(data);
        LockFreeNode<T> newNode = new LockFreeNode<T>(data);
        LockFreeNode<T> curNode = null;
        // LockFreeNode<T> preNode = null;
        retry:
        while (true) {
            curNode = head.get();
            if (curNode == null) {
                if (head.compareAndSet(null, newNode))
                    return true;
                else
                    continue retry;
            } else {
                System.out.println(curNode);
                while (curNode.next != null) {
                    curNode = curNode.next.getReference();
                }
                if (curNode.isMarked()) {
                    continue retry;
                } else {
                    if (curNode.next.compareAndSet(null, newNode, false, false)) {
                        System.out.println("�ɹ���������" + newNode.data);
                        return true;
                    } else
                        continue retry;

                }
            }
        }
    }

    public T remove(T data) {
        LockFreeNode<T> curNode = null;
        LockFreeNode<T> preNode = null;
        retry:
        while (true) {
            curNode = head.get();
            if (curNode == null) {
                return null;
            } else {
                if (curNode.data == data) {
                    if (head.compareAndSet(curNode, null)) {
                        return curNode.data;
                    } else {
                        continue retry;
                    }
                } else {
                    while (curNode.data != data || curNode.next != null) {
                        preNode = curNode;
                        curNode = curNode.next.getReference();
                    }
                    if (curNode.next == null) {
                        return null;
                    } else {
                        if (preNode.next.compareAndSet(curNode,
                                curNode.next.getReference(), false, false)) {
                            curNode.mark();
                            System.out.println("��ɾ������" + data);
                            return curNode.data;
                        } else {
                            continue retry;
                        }
                    }
                }
            }
        }
    }

    public boolean contains(T data) {
        LockFreeNode<T> curNode = head.get();
        while (curNode.data == data && curNode.next != null) {
            curNode = curNode.next.getReference();
        }
        if (curNode.next == null) {
            return false;
        } else {
            return true;
        }
    }

}
