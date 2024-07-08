package book.ch3.sleep;

public class Worker extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.print(" " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
