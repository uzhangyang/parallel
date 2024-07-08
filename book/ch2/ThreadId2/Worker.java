package book.ch2.ThreadId2;

public class Worker extends Thread {
    @Override
    public void run() {
        System.out.println("�߳�" + this.getId() + "��������...");
    }
}
