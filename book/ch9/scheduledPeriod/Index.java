package book.ch9.scheduledPeriod;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Index {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        Machine machine = new Machine(0);
        Monitor monitor = new Monitor(machine, scheduler);
        scheduler.scheduleAtFixedRate(machine, 1, 2, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(monitor, 0, 1, TimeUnit.SECONDS);
    }
}
