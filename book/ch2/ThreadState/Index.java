package book.ch2.ThreadState;

import java.lang.Thread.State;

public class Index {
    public static void main(String[] args) {
        Thread t1 = new Worker("��ͨ����");
        Thread t2 = new Worker("��������");
        t1.start();
        t2.start();
        while (true) {
            if (t1.isAlive()) {
                System.out.println(t1.getName() + "(�߳�)��������~~~");
            }
            if (t1.getState() == State.TIMED_WAITING) {
                System.out.println(t1.getName() + "(�߳�)���ڵȴ�...");
            }
            if (t2.isAlive()) {
                System.out.println(t2.getName() + "(�߳�)��������~~~");
            }
            if (t2.getState() == State.TIMED_WAITING) {
                System.out.println(t2.getName() + "(�߳�)���ڵȴ�...");
            }
        }
    }
}
