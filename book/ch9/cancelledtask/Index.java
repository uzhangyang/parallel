package book.ch9.cancelledtask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Index {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Worker worker = new Worker();
        Future<String> future = executor.submit(worker);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人的工作即将被终止");
        future.cancel(true);
        System.out.println("终止情况:"+future.isCancelled());

        executor.shutdown();
    }
}
