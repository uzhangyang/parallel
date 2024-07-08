package book.ch2.ThreadNameChanged;


public class Index {
    public static void main(String[] args) {
        Thread t1 = new Worker("Normal worker");
        Thread t2 = new Worker("Skilled worker");
        t1.start();
        t2.start();
    }
}
