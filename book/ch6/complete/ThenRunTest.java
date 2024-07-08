package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenRunTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"第一个异步任务开始执行...");
            return null;
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName()+"第二个异步任务开始执行...");
        }).get();
    }

}
