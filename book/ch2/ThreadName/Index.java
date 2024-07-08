package book.ch2.ThreadName;

public class Index {
    public static void main(String[] args) {
//		Thread t1 = new Thread(new Worker());
//		Thread t2 = new Thread(new Worker());
        Thread t1 = new Thread(new Worker(), "t1");
        Thread t2 = new Thread(new Worker(), "t2");

        t1.start();
        t2.start();
    }
}
