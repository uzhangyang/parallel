package book.ch2.creator;

public class Worker extends Thread {
    private int id;

    public Worker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("�߳�-" + id + " ���ڴ�ӡ " + i);
        }
    }
}
