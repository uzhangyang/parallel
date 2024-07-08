package book.ch6.name;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest2 {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        CompletableFuture<String> name = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex){
                throw new IllegalStateException(ex);
            }
            return "张";
        }).thenApply(firstName->{
            return firstName + "杨";
        }).thenApply(fullName ->{
            return fullName + "是我的名字";
        });
        System.out.println(name.get());
    }
}
