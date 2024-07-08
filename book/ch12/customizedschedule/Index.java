package book.ch12.customizedschedule;

import java.util.concurrent.TimeUnit;

public class Index {
    public static void main(String[] args) {
        PrintInfoThreadPoolExecutor executor = new PrintInfoThreadPoolExecutor(2);
        Worker worker = new Worker();
        executor.scheduleAtFixedRate(worker, 1, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
