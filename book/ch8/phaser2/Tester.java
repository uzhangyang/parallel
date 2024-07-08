package book.ch8.phaser2;

import java.util.concurrent.Phaser;

public class Tester extends Thread {

    Phaser phaser;

    Tester(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run(){
        System.out.println(this.getName()+"已经到达考场。");
        phaser.arriveAndAwaitAdvance();
        System.out.println(this.getName()+"等待老师发卷...");
        phaser.arriveAndAwaitAdvance();
        System.out.println(this.getName()+"正在答试卷一...");
        phaser.arriveAndAwaitAdvance();
        System.out.println(this.getName()+"正在答试卷二...");
        phaser.arriveAndAwaitAdvance();
        System.out.println(this.getName()+"正在等待宣布考试结束...");
        phaser.arriveAndDeregister();
    }

}
