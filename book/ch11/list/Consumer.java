package book.ch11.list;

public class Consumer extends Thread {
    MyList list;

    Consumer(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.removeFirst();
        }
    }
}
