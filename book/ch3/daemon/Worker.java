package book.ch3.daemon;

import java.util.LinkedList;

public class Worker extends Thread {
    private LinkedList<Integer> list;

    public Worker(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int newData = (int) (Math.random() * 1000);
            list.addFirst(newData);
            System.out.println("新的数据" + newData + "被插入列表, Size=" + list.size());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
