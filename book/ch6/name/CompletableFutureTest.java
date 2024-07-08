package book.ch6.name;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {
    public static void main(String[] args){
        CompletableFuture<String> lastNameFuture = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex){
                throw new IllegalStateException(ex);
            }
            return "张";
        });
        CompletableFuture<String> nameFuture = lastNameFuture.thenApply(lastName ->{
           return  lastName + " 杨";
        });
        try {
            System.out.println(nameFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
