package book.ch2.priority;


public class Index {
    public static void main(String[] args) {
        Thread one = new Worker("�߳�1", Thread.MIN_PRIORITY);
        Thread two = new Worker("�߳�2", Thread.MIN_PRIORITY);
        Thread three = new Worker("�߳�3", Thread.MAX_PRIORITY);
        Thread four = new Worker("�߳�4", Thread.MAX_PRIORITY);
        one.start();
        two.start();
        three.start();
        four.start();
    }
}
