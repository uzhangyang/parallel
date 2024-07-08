package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ThenAcceptTest {

    public static void main(String[] args){
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(new Supplier<String>(){
            @Override
            public String get(){
                System.out.println(Thread.currentThread().getName()+ " 第一个异步任务开始执行...");
                return "14";
            }
        });
        CompletableFuture<Integer> task2 = task1.thenApply(number ->{
            System.out.println(Thread.currentThread().getName()+" 第二个异步任务开始执行...");
            return Integer.parseInt(number);
        }).thenApply(n->{
            System.out.println(Thread.currentThread().getName()+" 第三个异步任务开始执行...");
            return n*2;
        });
        CompletableFuture<Void> task4 = task2.thenAccept(p ->{
            System.out.println(Thread.currentThread().getName()+" 第四个异步任务开始执行...");
            System.out.println("执行结果："+p);
        });
        System.out.println("异步执行结束");
    }
}
