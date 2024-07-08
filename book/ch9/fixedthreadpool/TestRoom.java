package book.ch9.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRoom {
    ExecutorService testPool = Executors.newFixedThreadPool(4);

    public void test(Student student) {
        testPool.execute(student);
    }

    public void endTest() {
        if (!testPool.isShutdown())
            testPool.shutdown();
    }

}
