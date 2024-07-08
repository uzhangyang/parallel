package book.ch9.threadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Employer {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public void dispatch(Worker worker) {
        System.out.println("雇主正在派遣工人到工作岗位上。");
        executor.execute(worker);
        System.out.println("活动的线程数为:"+executor.getActiveCount());
        System.out.println("线程池大小为"+executor.getPoolSize());

    }

    public void endWork() {
        executor.shutdown();
    }
}
