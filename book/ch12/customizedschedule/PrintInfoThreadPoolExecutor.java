package book.ch12.customizedschedule;

import java.util.Date;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrintInfoThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public PrintInfoThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
        System.out.println("线程池运行开始于"+new Date().toString());
    }
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable,
                                                          RunnableScheduledFuture<V> task){
        CustomizedScheduleTask<V> myTask = new
                CustomizedScheduleTask<V>(runnable, null, task, this);
        return myTask;
    }
    @Override
    public void shutdown(){
        super.shutdown();
        System.out.println("线程池终止申请提交于" + new Date().toString());
    }



    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay, long period, TimeUnit unit) {

        ScheduledFuture<?> task = super.scheduleAtFixedRate(command, initialDelay, period, unit);
        CustomizedScheduleTask<?> ctask = (CustomizedScheduleTask<?>) task;
        ctask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit));
//		System.out.println("���˹���������һ��");
        return task;
    }
}
