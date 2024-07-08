package book.ch2.creator;

public class Index {
    public static void main(String[] args) {
        Worker worker1 = new Worker(1);
        Worker worker2 = new Worker(2);
        worker1.start();
        worker2.start();
    }
}
