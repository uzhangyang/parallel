package book.ch4.livelock2;

public class Index {
    public static void main(String[] args) {
        String name = "NormalThread";
        Thread thread1 = new Worker(name);
        String name2 = "ErgentThread";
        Thread thread2 = new Worker(name2);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }

}
