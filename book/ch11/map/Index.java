package book.ch11.map;

import java.util.concurrent.ConcurrentHashMap;

public class Index {
    public static void main(String[] args) {
        int nthrd = 2;
        ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<Integer, String>();
        Thread[] threads = new Thread[nthrd];
        for (int i = 0; i < nthrd; i++) {
            threads[i] = new Worker(i + 1, hashMap);
            threads[i].start();
        }

//        java.util.Collections.synchronizedMap()

    }
}
