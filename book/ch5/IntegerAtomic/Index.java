package book.ch5.IntegerAtomic;


public class Index {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Worker(counter);
        Thread t2 = new Worker(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("counter.get() = " + counter.get());
    }

}
