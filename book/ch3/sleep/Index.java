package book.ch3.sleep;

public class Index {
    public static void main(String[] args) {
        Thread worker1 = new Worker();
        Thread worker2 = new Worker();
        worker1.start();
        worker2.start();
    }
}
