package book.ch4.reentrantlock;

public class ReadThread extends Thread {
    int id;
    ReenTest test;
    int num;

    public ReadThread(int id, ReenTest test, int executeTimes) {
        this.id = id;
        this.test = test;
        num = executeTimes;
    }

    public void run() {
        //System.out.println("读线程"+id+"开始运行");
        int index;
        for (int i = 0; i < num; i++) {
            index = id * num + i;
            test.get(index);
        }
        //System.out.println("读线程"+id+"结束运行");
    }
}
