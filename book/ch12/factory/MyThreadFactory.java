package book.ch12.factory;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private String name;
    private int threadNumber;

    MyThreadFactory(String name) {
        this.name = name;
        threadNumber = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        String rName = name+"-线程"+threadNumber;
        Thread thread = new Thread(r, rName);
        System.out.println("新建了一个线程");
        threadNumber++;
        return thread;

    }

}
