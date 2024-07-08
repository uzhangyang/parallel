package book.ch7.singlepc;

public class Index {

    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer producer = new Producer(c);
        producer.start();
        Consumer consumer = new Consumer(c);
        consumer.start();
    }

}
