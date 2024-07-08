package book.ch3.threadlocal;

public class Index {
    public static void main(String[] args) {
        Thread t1 = new Worker();
        Thread t2 = new Worker();
        t1.start();
        t2.start();
    }
}
