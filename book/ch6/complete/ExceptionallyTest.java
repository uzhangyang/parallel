package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class ExceptionallyTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int age=-1;
        CompletableFuture<String> task= CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                if(age<0)
                    throw new IllegalArgumentException("输入年龄值不合法");
                else
                    return "年龄值正常";

            }
        }).exceptionally(ex->{
            System.out.println(ex.getMessage());
            return "产生异常："+ex.getMessage();
        });
        System.out.println(task.get());
    }
}
