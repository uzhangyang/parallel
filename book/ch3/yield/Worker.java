package book.ch3.yield;

public class Worker extends Thread {
    public void run() {
        System.out.println(this.getName() + "开始执行");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                Thread.yield();
                System.out.println(this.getName() + "让出了CPU的使用权");
            }
            System.out.println(this.getName() + "正在输出" + i);
        }
        System.out.println(this.getName() + "结束");
    }
}
