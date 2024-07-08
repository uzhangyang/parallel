package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


//https://cloud.tencent.com/developer/article/1366581
public class FlowTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


    }

    public static void testCompletableFuture(){
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
        });
        CompletableFuture<Integer> task3 = task2.thenApply(n->{
            System.out.println(Thread.currentThread().getName()+" 第三个异步任务开始执行...");
            return n*2;
        });
        CompletableFuture<Void> task4 = task3.thenAccept(p ->{
            System.out.println(Thread.currentThread().getName()+" 第四个异步任务开始执行...");
            System.out.println("执行结果："+p);
        });
        System.out.println("异步执行结束");
    }




    public static void testCompletableFuture4() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+ " 第一个异步任务开始执行...");
            return null;
        });
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+" 第二个异步任务开始执行...");
            return null;
        });
        CompletableFuture<String> task3 = task2.thenApplyAsync(v->{
            System.out.println(Thread.currentThread().getName()+" 第二个异步任务的子任务开始执行...");
            return null;
        });
        Thread.sleep(4);
        System.out.println(Thread.currentThread().getName()+task3.get());
    }










}
