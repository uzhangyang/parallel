package book.ch4.reentrantlock;


public class WriteThread extends Thread {
    int id;
    ReenTest test;
    int num;

    public WriteThread(int id, ReenTest test, int executeTimes) {
        this.id = id;
        this.test = test;
        num = executeTimes;
    }

    public void run() {
        //System.out.println("写线程"+id+"开始运行");
        for (int i = 0; i < num; i++) {
            test.insert(id * num + i);
        }
        //System.out.println("写线程"+id+"开始运行");
    }
}
