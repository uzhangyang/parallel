package book.ch6.waitall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Index {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("等待所有的异步任务完成示例：");
        waitAll();
        System.out.println("等待任一异步任务完成示例：");
        waitAny();
    }
    public static void waitAll() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer>[] cfs = new CompletableFuture[3];
        for (int i = 0; i < 3; i++) {
            cfs[i] = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return (int) (Math.random() * 100);
                }
            });
        }
        CompletableFuture.allOf(cfs).get();
        for (CompletableFuture cf : cfs) {
            System.out.println(cf.get());
        }
    }

    public static void waitAny() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "等待4秒";
            }
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "等待2秒";
            }
        });
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "等待6秒";
            }
        });


        CompletableFuture<Object> result = CompletableFuture.anyOf(cf1, cf2, cf3);


        System.out.println(result.get());
    }


}
