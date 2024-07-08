package book.ch9.scheduledPeriod;

import java.util.concurrent.ScheduledExecutorService;

public class Monitor implements Runnable {
    Machine machine;
    ScheduledExecutorService scheduler;
    static int n = 0;

    Monitor(Machine machine, ScheduledExecutorService scheduler) {
        this.machine = machine;
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        if(machine.getTemperature() >= 10){
            System.out.println("警告:机器温度过高.");
            n++;
        }
        if(n>10){
            System.out.println("提醒次数限制已到,终止任务");
            scheduler.shutdown();
        }

    }
}
