package book.ch11.list;

public class Index {
    public static void main(String[] args) {
        MyList list = new MyList();
        Thread t1 = new Producer(list);
        Thread t2 = new Producer(list);
        t1.start();
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t3 = new Consumer(list);
        Thread t4 = new Consumer(list);
        t3.start();
        t4.start();
    }
}
