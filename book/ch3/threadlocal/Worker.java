package book.ch3.threadlocal;

import java.util.Date;

public class Worker extends Thread {

    ThreadLocal<Date> timeStamp = new ThreadLocal<Date>() {
        protected Date initialValue() {
            return new Date();
        }
    };


    @Override
    public void run() {
        System.out.println(getName()+"线程启动于"+timeStamp.get());
    }
}
