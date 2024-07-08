package book.ch9.scheduleddelay;

public class Printer implements Runnable {
    @Override
    public void run() {
        System.out.println("开始打印");
        // 添加一些打印任务...
        System.out.println("打印结束");

    }

}
