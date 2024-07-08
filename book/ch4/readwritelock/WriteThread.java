package book.ch4.readwritelock;


public class WriteThread extends Thread {
    int id;
    ReWrTest test;
    int num;

    public WriteThread(int id, ReWrTest test, int executeTimes) {
        this.id = id;
        this.test = test;
        num = executeTimes;
    }

    public void run() {
        for (int i = 0; i < num; i++) {
            test.insert(id * num + i);
        }
    }
}
