package book.ch2.ThreadName;

public class Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " prints " + i);
        }
    }
}
