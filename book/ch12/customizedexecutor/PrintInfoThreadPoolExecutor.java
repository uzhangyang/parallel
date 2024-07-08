package book.ch12.customizedexecutor;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrintInfoThreadPoolExecutor extends ThreadPoolExecutor {

    public PrintInfoThreadPoolExecutor(int corePoolSize,
                                       int maximumPoolSize,
                                       long keepAliveTime,
                                       TimeUnit unit,
                                       BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        System.out.println("线程池运行开始于"+new Date().toString());
    }
    public void shutdown(){
        super.shutdown();
        System.out.println("线程池终止运行于" + new Date().toString());
    }
    public void execute(Runnable command){
        super.execute(command);
        System.out.println("正在处理任务"+command);
    }


}
