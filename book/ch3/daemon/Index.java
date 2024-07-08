package book.ch3.daemon;

import java.util.LinkedList;

public class Index {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Thread worker = new Worker(list);
        Thread cleaner = new Cleaner(list);
        worker.start();
        cleaner.start();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("Java虚拟机退出");
            }
        });
    }
}
