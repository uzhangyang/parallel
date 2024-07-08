package book.ch12.usingfactoryonexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Index {
    public static void main(String[] args) {
        ChineseThreadFactory factory = new ChineseThreadFactory();
        ExecutorService executor = Executors.newCachedThreadPool(factory);
        Worker worker = new Worker();
        executor.submit(worker);
        executor.shutdown();
    }
}
