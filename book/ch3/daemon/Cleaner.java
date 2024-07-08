package book.ch3.daemon;

import java.util.LinkedList;

public class Cleaner extends Thread {
    private LinkedList<Integer> list;

    public Cleaner(LinkedList<Integer> list) {
        this.list = list;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            if (!list.isEmpty()) {
                list.removeLast();
                System.out.println("一个数据已经被移除。");
            }
        }
    }
}
