package book.ch2.ThreadId;

public class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("�߳�" + Thread.currentThread().getId()
                + "��������...");
    }
}
