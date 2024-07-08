package book.ch2.ThreadState;

public class Worker extends Thread {
    public Worker(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 1000; i++) ;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
