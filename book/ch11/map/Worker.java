package book.ch11.map;

import java.util.concurrent.ConcurrentHashMap;

public class Worker extends Thread {
    int id;
    ConcurrentHashMap<Integer, String> hashMap;

    Worker(int id, ConcurrentHashMap<Integer, String> hashMap) {
        this.id = id;
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Integer temp = id * (i + 1);
            hashMap.put(temp, "学号"+temp);
            System.out.println("向哈希表中放入了:<"+temp+", 学号"+temp+">");
        }
    }
}
