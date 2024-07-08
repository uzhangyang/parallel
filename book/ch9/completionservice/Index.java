package book.ch9.completionservice;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Index {
    public static void main(String[] args) {
        int taskNum = 8;
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<Long> service = new ExecutorCompletionService<Long>(
                executor);
        for (int i = 0; i < taskNum; i++) {
            service.submit(new Worker());
        }
        Future<Long> future = null;
        Long timeTotal = 0L;
        for (int i = 0; i < taskNum; i++) {
            try {
                future = service.take();
                timeTotal += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(taskNum+"个任务执行的总时间为:"+timeTotal+"毫秒");
        executor.shutdown();
    }
}
