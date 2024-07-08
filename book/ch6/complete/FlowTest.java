package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class FlowTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(new Supplier<String>(){
            @Override
            public String get(){
                System.out.println(Thread.currentThread().getName()+ " 第一个异步任务开始执行...");
                return "1980";
            }
        });
        CompletableFuture<Integer> task2 = task1.thenApply(number ->{
            System.out.println(Thread.currentThread().getName()+" 第二个异步任务开始执行...");
            return Integer.parseInt(number);
        });
        CompletableFuture<Integer> task3 = task2.thenApply(n->{
           System.out.println(Thread.currentThread().getName()+" 第三个异步任务开始执行...");
           return n*2;
        });
        System.out.println("异步执行结果为："+task3.get());
    }

}
