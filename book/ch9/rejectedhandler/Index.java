package book.ch9.rejectedhandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Index {

    public static void main(String[] args) {
        int taskNum = 4;
        RejectedHandler rejectedHandler = new RejectedHandler();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(rejectedHandler);
        System.out.println("当前执行器将要处理"+taskNum+"个任务");
        for(int i=0; i<taskNum; i++){
            executor.submit(new Task("任务"+i));
        }
        System.out.println("即将关闭执行器");
        executor.shutdown();
        System.out.println("一个新的任务即将被提交到执行器");
        executor.submit(new Task("新任务"));

    }

}
