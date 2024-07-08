package book.ch8.phaser;

import java.util.concurrent.Phaser;

public class Index {
    public static void main(String[] args) {
        int dataSize = 4000000;
        int nthread = 4;
        int findValue = 20;
        int[] bigData = new int[dataSize];
        for (int i = 0; i < dataSize; i++) {
            bigData[i] = (int) (Math.random() * 100);
        }
        int[] range = new int[nthread + 1];
        int slice = dataSize / nthread;
        for (int i = 0; i <= nthread; i++) {
            range[i] = slice * i;
            if (range[i] > dataSize)
                range[i] = dataSize;
        }
        Phaser phaser = new Phaser(nthread);
        Thread[] threads = new Thread[nthread];
        for (int i = 0; i < nthread; i++) {
            threads[i] = new Searcher(bigData, range[i], range[i + 1], findValue, phaser);
            threads[i].start();
        }
        for (int i = 0; i < nthread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束，phaser的终止状态为:"
                + phaser.isTerminated());

    }
}
