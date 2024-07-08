package book.ch12.customizedschedule;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CustomizedScheduleTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {

    private RunnableScheduledFuture<V> task;
    private PrintInfoThreadPoolExecutor executor;
    private long period;
    private long startDate;


    public CustomizedScheduleTask(Runnable runnable, V result, RunnableScheduledFuture<V> task, PrintInfoThreadPoolExecutor executor) {
        super(runnable, result);
        this.task = task;
        this.executor = executor;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        if (!isPeriodic()) {
            return task.getDelay(unit);
        } else {
            if (startDate == 0) {
                return task.getDelay(unit);
            } else {
                Date now = new Date();
                long delay = startDate - now.getTime();
                return unit.convert(delay, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override
    public int compareTo(Delayed delay) {
        return task.compareTo(delay);
    }

    @Override
    public boolean isPeriodic() {
        return task.isPeriodic();
    }

    @Override
    public void run() {
        if (isPeriodic() && (!executor.isShutdown())) {
            Date now = new Date();
            startDate = now.getTime() + period;
            executor.getQueue().add(this);
            System.out.println("任务已经被加入到队列中");
        }
        super.runAndReset();
    }

    public void setPeriod(long period) {
        this.period = period;
    }


}
