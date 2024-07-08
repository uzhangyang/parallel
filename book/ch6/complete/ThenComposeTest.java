package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class ThenComposeTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "1";
            }
        });
        CompletableFuture<String> task2 = task1.thenCompose(value->CompletableFuture.supplyAsync(()->{
            return value+"-one";
        }));
        System.out.println(task2.get());
    }
}

