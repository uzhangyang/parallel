package book.ch4.problem;

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
