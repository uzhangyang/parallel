package book.ch11.list;

import java.util.concurrent.ConcurrentLinkedDeque;

public class MyList {
    private ConcurrentLinkedDeque<Integer> list = new ConcurrentLinkedDeque<Integer>();

    public void add(Integer e) {
        list.add(e);
        System.out.println("向列表中加入了"+e);
    }
    public void removeFirst(){
        System.out.println("从列表中移除了"+list.pollFirst());
    }
}
