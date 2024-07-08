package book.ch11.skiplist;

import java.util.concurrent.ConcurrentSkipListMap;

public class Index {
    public static void main(String[] args) {
        int N = 4;
        ConcurrentSkipListMap<Integer, String> skiplist = new ConcurrentSkipListMap<Integer, String>();
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Worker(i, skiplist);
            threads[i].start();
        }
        for (int i = 0; i < N; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("skiplist.size=" + skiplist.size());
    }
}
