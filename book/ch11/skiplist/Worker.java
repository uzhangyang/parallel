package book.ch11.skiplist;

import java.util.concurrent.ConcurrentSkipListMap;

public class Worker extends Thread {
    int id;
    ConcurrentSkipListMap<Integer, String> skiplist;

    Worker(int id, ConcurrentSkipListMap<Integer, String> skiplist) {
        this.id = id;
        this.skiplist = skiplist;
    }

    @Override
    public void run() {
        System.out.println("id="+id+"线程开始运行");
        for(int i=0; i<1000; i++){
            int temp = id * 1000 + (i+1);
            if(i<500){
                skiplist.put(temp, "零件"+temp);
                System.out.println("id="+id+"线程放入<"+temp+",零件"+temp+">");
            }else{
                int t = temp-500;
                skiplist.remove(t);
                System.out.println("id="+id+"线程移除<"+t+ ",零件"+t+">");
            }
        }

    }
}
