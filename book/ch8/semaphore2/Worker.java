package book.ch8.semaphore2;

public class Worker implements Runnable {
    private Data data;

    Worker(Data data) {
        this.data = data;
    }

    public void run() {
        while (true) {
            data.increase();
        }
    }
}
