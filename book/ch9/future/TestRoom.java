package book.ch9.future;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestRoom {
    ExecutorService testPool;
    Map<Student, Future<Long>> stuToTimeMap;

    TestRoom() {
        testPool = Executors.newFixedThreadPool(4);
        stuToTimeMap = new HashMap<Student, Future<Long>>();
    }

    public void test(Student student) {
        Future<Long> result = testPool.submit(student);
        stuToTimeMap.put(student, result);
    }

    public Long getTime(Student student) {
        Future<Long> result = stuToTimeMap.get(student);
        try {
            return result.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void endTest() {
        if (!testPool.isShutdown())
            testPool.shutdown();
    }

}
