package book.ch8.phaser2;

import java.util.concurrent.Phaser;

public class Index {

    public static void main(String[] args) {
        int tester_num = 3;
        Phaser phaser = new CustomizedPhaser();
        Thread[] testers = new Thread[tester_num];
        for (int i = 0; i < tester_num; i++) {
            testers[i] = new Tester(phaser);
            phaser.register();
            testers[i].start();
        }
        for (int i = 0; i < tester_num; i++) {
            try {
                testers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
