package book.ch9.rejectedhandler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
        System.out.println("执行器的终止状态为:"+arg1.isTerminated());
        System.out.println("任务"+arg0.toString()+"的执行被执行器拒绝.");

    }
}
