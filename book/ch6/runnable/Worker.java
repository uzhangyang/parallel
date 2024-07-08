package book.ch6.runnable;

public class Worker implements Runnable{
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("模拟航天发射任务...");
    }

}
