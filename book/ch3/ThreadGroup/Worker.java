package book.ch3.ThreadGroup;

public class Worker implements Runnable {
    int counter = 0;

    @Override
    public void run() {
        for(int i=0; i<Integer.MAX_VALUE; i++){
            counter++;
        }
        System.out.println(Thread.currentThread().getName()+"已经停止执行");
    }

}
