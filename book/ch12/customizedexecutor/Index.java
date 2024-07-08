package book.ch12.customizedexecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Index {

    public static void main(String[] args) {
        PrintInfoThreadPoolExecutor executor = new PrintInfoThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        Task task = new Task();
        executor.execute(task);
        executor.shutdown();
    }
}
