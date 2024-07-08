package book.ch3.join;

public class PrintTask implements Runnable {
    Thread thread;

    PrintTask(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum=" + Index.sum);
    }
}
