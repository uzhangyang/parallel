package book.ch9.cancelledtask;

import java.util.concurrent.Callable;

public class Worker implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true) {
            System.out.println("工人正在工作...");
            Thread.sleep(1000);
        }
    }

}
