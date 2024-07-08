package book.ch12.factory;

public class Index {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("线程工厂1");
        Worker worker = new Worker();
        Thread thread = factory.newThread(worker);
        thread.start();
    }
}
