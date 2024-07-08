package book.ch5.IntegerAtomic;

public class Worker extends Thread {

    Counter counter;

    Worker(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.increase();
        }
    }
}
