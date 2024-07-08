package book.ch2.ThreadId;

public class Index {
    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Thread t1 = new Thread(worker1);
        Worker worker2 = new Worker();
        Thread t2 = new Thread(worker2);
        t1.start();
        t2.start();
    }
}
