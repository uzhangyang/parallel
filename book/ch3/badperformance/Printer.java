package book.ch3.badperformance;

public class Printer extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName()+"正在运行");
    }
}
