package book.ch11.list;

public class Producer extends Thread {
    MyList list;

    Producer(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }
}
