package book.ch4.livelock2;
public class Worker extends Thread {

    String name;
    static Integer id = 1;

    Worker(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " 开始运行...");
        if (id < 20) {
            Thread newThread = new Worker("Thread-" + id.toString());
            newThread.setPriority(MAX_PRIORITY);
            newThread.start();
        }
        id++;
    }
}
