package book.ch12.workthreadinforkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class PrintInfoWorkerThread extends ForkJoinWorkerThread {

    protected PrintInfoWorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    protected void onStart(){
        System.out.println(super.getName()+"即将开始运行...");
        super.onStart();
    }
    @Override
    protected void onTermination(Throwable exception){
        System.out.println(super.getName()+"即将终止运行...");
        super.onTermination(exception);
    }
    @Override
    public void run(){
        System.out.println(super.getName()+"正在运行...");
        super.run();
    }

}
