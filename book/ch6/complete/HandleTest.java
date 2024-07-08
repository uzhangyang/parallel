package book.ch6.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class HandleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int age = 20;
        CompletableFuture<String> task = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                if (age < 0 || age >= 150) {
                    throw new IllegalArgumentException("年龄值不合法");
                } else
                    return "年龄值正常";
            }
        }).handle((res, ex) -> {
            System.out.println("执行handle");
            if (ex != null) {
                System.out.println("发生异常");
                return "返回异常" + ex.getMessage();
            }
            return res;
        });
        System.out.println(task.get());
    }
}
