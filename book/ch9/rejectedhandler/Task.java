package book.ch9.rejectedhandler;

public class Task implements Runnable {

    String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("工作"+name+"开始运行");
        try {
            int time = (int) (Math.random() * 10000);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前工作"+name+"执行结束");

    }

    public String toString() {
        return name;
    }

}
