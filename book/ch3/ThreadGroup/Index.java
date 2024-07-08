package book.ch3.ThreadGroup;

public class Index {
    public static void main(String[] args) {
        int threadNum = 5;
        ThreadGroup parentGroup = new ThreadGroup("父线程组");
        ThreadGroup childGroup = new ThreadGroup(parentGroup,"子线程组");
        Worker worker = new Worker();
        Thread[] threads = new Thread[threadNum * 2];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(childGroup, worker);
            threads[i].start();
        }
        System.out.println(threadNum+"个线程被加入到子线程组 ");
        for (int i = 0; i < threadNum; i++) {
            threads[threadNum + i] = new Thread(parentGroup, worker);
            threads[threadNum + i].start();
        }
        System.out.println(threadNum+"个线程被加入到父线程组 ");
        System.out.println("在" + parentGroup.getName()
                + "中活动线程数为： " + parentGroup.activeCount());
        childGroup.stop();
        System.out.println("子线程组已经被停止");
        parentGroup.stop();
        System.out.println("父线程组已经被停止");
    }

}
