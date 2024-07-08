package book.ch8.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class Searcher extends Thread {
    int[] array;
    int begin;
    int end;
    Phaser phaser;
    int findValue;
    List<Integer> results;

    Searcher(int[] array, int begin, int end, int findValue, Phaser phaser) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.findValue = findValue;
        this.phaser = phaser;
        results = new ArrayList<Integer>();
    }

    public void run() {
        phaser.arriveAndAwaitAdvance();
        for (int i = begin; i < end; i++) {
            if (array[i] == findValue) {
                results.add(i);
            }
        }
        System.out.println(getName()+"已经完成了第"
                +phaser.getPhase()+"阶段的任务。");
        phaser.arriveAndAwaitAdvance();
        for(Integer result : results){
            array[result]++;
        }
        System.out.println(getName()+"已经完成了第"
                +phaser.getPhase()+"阶段的任务。");
        phaser.arriveAndAwaitAdvance();
        System.out.println(getName()+"开始第"+phaser.getPhase()
                +"个阶段。共改变了"+results.size()+"个。");
        phaser.arriveAndDeregister();

    }
}
