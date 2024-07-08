package book.ch12.usingfactoryonexecutor;

import java.util.concurrent.ThreadFactory;

public class ChineseThreadFactory implements ThreadFactory {

    private int totalNumber;

    ChineseThreadFactory() {

        totalNumber = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        String rName = "线程工厂中的线程"+totalNumber;
        Thread thread = new Thread(r, rName);
        System.out.println("新建线程为:" + rName);

        totalNumber++;
        return thread;
    }

}
